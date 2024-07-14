package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.HomeViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.KKViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.ProdiViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private HomeViewModel mHomeViewModel;
    private RecyclerView mRecyclerView;
    private MateriAdapter mRiwayatMateriAdapter;
    private ProdiAdapter mProdiAdapter;
    private MateriAdapter mMateriTersimpanAdapter;
    private TextView mTxvRiwayat;
    private TextView mTxvTersimpan;
    private ImageButton mBtnLogout;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup RecyclerView untuk Riwayat Materi
        mRecyclerView = view.findViewById(R.id.recycler_riwayat_materi);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRiwayatMateriAdapter = new MateriAdapter();
        mRecyclerView.setAdapter(mRiwayatMateriAdapter);

        // Setup RecyclerView untuk Materi Tersimpan
        mRecyclerView = view.findViewById(R.id.recycler_materi_tersimpan);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMateriTersimpanAdapter = new MateriAdapter();
        mRecyclerView.setAdapter(mMateriTersimpanAdapter);

        // Setup RecyclerView untuk Prodi
        mRecyclerView = view.findViewById(R.id.recycler_program_studi);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mProdiAdapter = new ProdiAdapter();
        mRecyclerView.setAdapter(mProdiAdapter);

        mHomeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // Prodi
        mHomeViewModel.getListProdi().observe(getViewLifecycleOwner(), new Observer<List<ProdiModel>>() {
            @Override
            public void onChanged(List<ProdiModel> prodiViewVOS) {
                mProdiAdapter.setProdiList(prodiViewVOS);
            }
        });
        // Riwayat Materi
        mHomeViewModel.getRiwayatMateri("0320220086").observe(getViewLifecycleOwner(), new Observer<List<MateriModel>>() {
            @Override
            public void onChanged(List<MateriModel> materiViewVOS) {
                if (materiViewVOS != null && !materiViewVOS.isEmpty()) {
                    mRiwayatMateriAdapter.setSingleMateri(materiViewVOS.get(0));
                }
            }
        });

        // Materi Tersimpan
        mHomeViewModel.getMateriTersimpan("0320220086").observe(getViewLifecycleOwner(), new Observer<List<MateriModel>>() {
            @Override
            public void onChanged(List<MateriModel> materiViewVOS) {
                if (materiViewVOS != null && !materiViewVOS.isEmpty()) {
                    mMateriTersimpanAdapter.setSingleMateri(materiViewVOS.get(0));
                }
            }
        });

        // Tambahkan onClickListener untuk tombol logout
        mBtnLogout = view.findViewById(R.id.btn_logout);
        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new LoginFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // Tambahkan onClickListener untuk "Tampilkan Semua" TextView
        mTxvRiwayat = view.findViewById(R.id.txv_riwayat);
        mTxvRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new RiwayatMateriFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mTxvTersimpan = view.findViewById(R.id.txv_tersimpan);
        mTxvTersimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new MateriTersimpanFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private static class ProdiAdapter extends RecyclerView.Adapter<ProdiAdapter.ProdiViewHolder> {
        private List<ProdiModel> prodiList = new ArrayList<>();

        @NonNull
        @Override
        public ProdiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prodi, parent, false);
            return new ProdiViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProdiViewHolder holder, int position) {
            ProdiModel prodi = prodiList.get(position);
            holder.mTxvNamaProdi.setText(prodi.getPro_nama());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KKViewModel kkViewModel = new ViewModelProvider((FragmentActivity) v.getContext()).get(KKViewModel.class);

                    KKFragment kkFragment = KKFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("prodi_id", prodi.getPro_id());
                    args.putString("nama_prodi", prodi.getPro_nama());
                    kkFragment.setArguments(args);
                    FragmentTransaction transaction = ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, kkFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return prodiList.size();
        }

        public void setProdiList(List<ProdiModel> prodiList) {
            this.prodiList = prodiList;
            notifyDataSetChanged();
        }

        static class ProdiViewHolder extends RecyclerView.ViewHolder {
            TextView mTxvNamaProdi;

            public ProdiViewHolder(@NonNull View itemView) {
                super(itemView);
                mTxvNamaProdi = itemView.findViewById(R.id.txv_namaProdi);
            }
        }
    }

    private static class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
        private MateriModel singleMateri;

        @NonNull
        @Override
        public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materi_home, parent, false);
            return new MateriViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
            if (singleMateri != null) {
                holder.mTxvJudulMateri.setText(singleMateri.getMatJudul());
                holder.mTxvDeskMateri.setText(singleMateri.getMatKeterangan());
            }
        }

        @Override
        public int getItemCount() {
            return singleMateri == null ? 0 : 1;
        }

        public void setSingleMateri(MateriModel materi) {
            this.singleMateri = materi;
            notifyDataSetChanged();
        }

        static class MateriViewHolder extends RecyclerView.ViewHolder {
            TextView mTxvJudulMateri, mTxvDeskMateri;

            public MateriViewHolder(@NonNull View itemView) {
                super(itemView);
                mTxvJudulMateri = itemView.findViewById(R.id.txv_judulMateri);
                mTxvDeskMateri = itemView.findViewById(R.id.txv_deskMateri);
            }
        }
    }
}

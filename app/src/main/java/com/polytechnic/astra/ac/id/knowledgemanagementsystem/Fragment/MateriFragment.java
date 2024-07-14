package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.KategoriViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.MateriViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.RiwayatMateriViewModel;

import java.util.ArrayList;
import java.util.List;

public class MateriFragment extends Fragment {
    private MateriViewModel mMateriViewModel;
    private RecyclerView mRecyclerView;
    private MateriAdapter mMateriAdapter;
    private String mKatId;
    private String mKatNama;
    private String mKatDesk;
    private String mProgramId;
    private String mNamaProgram;
    private static String mKKId;
    private static String mNamaKK;
    private static String mDeskKK;
    private String mProdiId;
    private String mProdiNama;

    public static MateriFragment newInstance() {
        return new MateriFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_materi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            mKatId = getArguments().getString("kategori_id");
            mKatNama = getArguments().getString("nama_kategori");
            mKatDesk = getArguments().getString("desk_kategori");
            mProgramId = getArguments().getString("program_id");
            mNamaProgram = getArguments().getString("nama_program");
            mKKId = getArguments().getString("kk_id");
            mNamaKK = getArguments().getString("nama_kk");
            mDeskKK = getArguments().getString("desk_kk");
            mProdiId = getArguments().getString("prodi_id");
            mProdiNama = getArguments().getString("nama_prodi");
            TextView txvProdi = view.findViewById(R.id.header_title);
            txvProdi.setText(mKatNama);
        }

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMateriAdapter = new MateriAdapter();
        mRecyclerView.setAdapter(mMateriAdapter);

        mMateriViewModel = new ViewModelProvider(this).get(MateriViewModel.class);

        // Panggil metode ViewModel dengan mProdiId
        mMateriViewModel.loadListMateriByKategori(mKatId);
        mMateriViewModel = new ViewModelProvider(this).get(MateriViewModel.class);
        mMateriViewModel.getListMateri().observe(getViewLifecycleOwner(), new Observer<List<MateriModel>>() {
            @Override
            public void onChanged(List<MateriModel> materiViewVOS) {
                mMateriAdapter.setMateriList(materiViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KategoriFragment kategoriFragment = KategoriFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("program_id", mProgramId);
                args.putString("nama_program", mNamaProgram);
                args.putString("kk_id", mKKId);
                args.putString("nama_kk", mNamaKK);
                args.putString("desk_kk", mDeskKK);
                args.putString("prodi_id", mProdiId);
                args.putString("nama_prodi", mProdiNama);
                kategoriFragment.setArguments(args);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, kategoriFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private static class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
        private List<MateriModel> materiList = new ArrayList<>();

        @NonNull
        @Override
        public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materi, parent, false);
            return new MateriViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
            MateriModel materi = materiList.get(position);
            holder.judul.setText(materi.getMatJudul());
            holder.keterangan.setText(materi.getMatKeterangan());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    DetailMateriFragment materiDetailFragment = DetailMateriFragment.newInstance();
//                    Bundle args = new Bundle();
//                    args.putString("mat_id", materi.getMatId());
//                    args.putString("mat_judul", materi.getMatJudul());
//                    args.putString("mat_keterangan", materi.getMatKeterangan());
//                    materiDetailFragment.setArguments(args);
//
//                    FragmentTransaction transaction = ((Fragment) v.getContext()).getParentFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragment_container, materiDetailFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return materiList.size();
        }

        public void setMateriList(List<MateriModel> materiList) {
            this.materiList = materiList;
            notifyDataSetChanged();
        }

        static class MateriViewHolder extends RecyclerView.ViewHolder {
            TextView judul, keterangan;

            public MateriViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.txv_judulMateri2);
                keterangan = itemView.findViewById(R.id.txv_dskMateri2);
            }
        }
    }
}

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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.KategoriViewModel;

import java.util.ArrayList;
import java.util.List;

public class KategoriFragment extends Fragment {
    private KategoriViewModel mKategoriViewModel;
    private RecyclerView mRecyclerView;
    private KategoriAdapter mKategoriAdapter;
    private String mProgramId;
    private String mNamaProgram;
    private String mDeskProgram;
    private static String mKKId;
    private static String mNamaKK;
    private static String mDeskKK;
    private static String mProdiId;
    private static String mProdiNama;

    public static KategoriFragment newInstance() {
        return new KategoriFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            mProgramId = getArguments().getString("program_id");
            mNamaProgram = getArguments().getString("nama_program");
            mDeskProgram = getArguments().getString("desk_program");
            mKKId = getArguments().getString("kk_id");
            mNamaKK = getArguments().getString("nama_kk");
            mDeskKK = getArguments().getString("desk_kk");
            mProdiId = getArguments().getString("prodi_id");
            mProdiNama = getArguments().getString("nama_prodi");

            TextView txvProdi = view.findViewById(R.id.header_title);
            txvProdi.setText(mNamaProgram);
        }

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mKategoriAdapter = new KategoriAdapter(getParentFragmentManager(), mProgramId, mNamaProgram);
        mRecyclerView.setAdapter(mKategoriAdapter);

        mKategoriViewModel = new ViewModelProvider(this).get(KategoriViewModel.class);

        mKategoriViewModel.loadListKategoriByProgram(mProgramId);

        mKategoriViewModel.getListKategori().observe(getViewLifecycleOwner(), new Observer<List<KategoriModel>>() {
            @Override
            public void onChanged(List<KategoriModel> kategoriViewVOS) {
                mKategoriAdapter.setKategoriList(kategoriViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgramFragment programFragment = ProgramFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("kk_id", mKKId);
                args.putString("nama_kk", mNamaKK);
                args.putString("desk_kk", mDeskKK);
                args.putString("prodi_id", mProdiId);
                args.putString("nama_prodi", mProdiNama);
                programFragment.setArguments(args);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, programFragment); // Menggunakan programFragment yang telah di-set dengan args
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private static class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {
        private List<KategoriModel> kategoriList = new ArrayList<>();
        private FragmentManager fragmentManager;
        private String mProgramId;
        private String mNamaProgram;

        public KategoriAdapter(FragmentManager fragmentManager, String mProgramId, String mNamaProgram) {
            this.fragmentManager = fragmentManager;
            this.mProgramId = mProgramId;
            this.mNamaProgram = mNamaProgram;
        }

        @NonNull
        @Override
        public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kategori, parent, false);
            return new KategoriViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
            KategoriModel kategori = kategoriList.get(position);
            holder.mJudul.setText(kategori.getKatNama());
            holder.mKeterangan.setText(kategori.getKatDeskripsi());
            holder.mJumlah.setText(kategori.getJumlahMateri());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MateriFragment materiFragment = MateriFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("kategori_id", kategori.getKatId());
                    args.putString("nama_kategori", kategori.getKatNama());
                    args.putString("desk_kategori", kategori.getKatDeskripsi());
                    args.putString("program_id", mProgramId);
                    args.putString("nama_program", mNamaProgram);
                    args.putString("kk_id", mKKId);
                    args.putString("nama_kk", mNamaKK);
                    args.putString("desk_kk", mDeskKK);
                    args.putString("prodi_id", mProdiId);
                    args.putString("nama_prodi", mProdiNama);
                    materiFragment.setArguments(args);
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container, materiFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return kategoriList.size();
        }

        public void setKategoriList(List<KategoriModel> kategoriList) {
            this.kategoriList = kategoriList;
            notifyDataSetChanged();
        }

        static class KategoriViewHolder extends RecyclerView.ViewHolder {
            TextView mJudul, mKeterangan, mJumlah;

            public KategoriViewHolder(@NonNull View itemView) {
                super(itemView);
                mJudul = itemView.findViewById(R.id.judul);
                mKeterangan = itemView.findViewById(R.id.deskripsi);
                mJumlah = itemView.findViewById(R.id.jumlah_materi);
            }
        }
    }
}

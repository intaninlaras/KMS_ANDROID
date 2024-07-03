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
    private KategoriViewModel kategoriViewModel;
    private RecyclerView recyclerView;
    private KategoriAdapter kategoriAdapter;
    private String programId;
    private String namaProgram;
    private String deskProgram;
    private static String KKId;
    private static String namaKK;
    private static String deskKK;
    private static String prodiId;
    private static String prodiNama;

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
            programId = getArguments().getString("program_id");
            namaProgram = getArguments().getString("nama_program");
            deskProgram = getArguments().getString("desk_program");
            KKId = getArguments().getString("kk_id");
            namaKK = getArguments().getString("nama_kk");
            deskKK = getArguments().getString("desk_kk");
            prodiId = getArguments().getString("prodi_id");
            prodiNama = getArguments().getString("nama_prodi");

            TextView txvProdi = view.findViewById(R.id.header_title);
            txvProdi.setText(namaProgram);
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        kategoriAdapter = new KategoriAdapter(getParentFragmentManager(), programId, namaProgram);
        recyclerView.setAdapter(kategoriAdapter);

        kategoriViewModel = new ViewModelProvider(this).get(KategoriViewModel.class);

        kategoriViewModel.loadListKategoriByProgram(programId);

        kategoriViewModel.getListKategori().observe(getViewLifecycleOwner(), new Observer<List<KategoriModel>>() {
            @Override
            public void onChanged(List<KategoriModel> kategoriViewVOS) {
                kategoriAdapter.setKategoriList(kategoriViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgramFragment programFragment = ProgramFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("kk_id", KKId);
                args.putString("nama_kk", namaKK);
                args.putString("desk_kk", deskKK);
                args.putString("prodi_id", prodiId);
                args.putString("nama_prodi", prodiNama);
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
        private String programId;
        private String namaProgram;

        public KategoriAdapter(FragmentManager fragmentManager, String programId, String namaProgram) {
            this.fragmentManager = fragmentManager;
            this.programId = programId;
            this.namaProgram = namaProgram;
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
            holder.judul.setText(kategori.getKatNama());
            holder.keterangan.setText(kategori.getKatDeskripsi());
            holder.jumlah.setText(kategori.getJumlahMateri());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MateriFragment materiFragment = MateriFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("kategori_id", kategori.getKatId());
                    args.putString("nama_kategori", kategori.getKatNama());
                    args.putString("desk_kategori", kategori.getKatDeskripsi());
                    args.putString("program_id", programId);
                    args.putString("nama_program", namaProgram);
                    args.putString("kk_id", KKId);
                    args.putString("nama_kk", namaKK);
                    args.putString("desk_kk", deskKK);
                    args.putString("prodi_id", prodiId);
                    args.putString("nama_prodi", prodiNama);
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
            TextView judul, keterangan, jumlah;

            public KategoriViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                keterangan = itemView.findViewById(R.id.deskripsi);
                jumlah = itemView.findViewById(R.id.jumlah_materi);
            }
        }
    }
}

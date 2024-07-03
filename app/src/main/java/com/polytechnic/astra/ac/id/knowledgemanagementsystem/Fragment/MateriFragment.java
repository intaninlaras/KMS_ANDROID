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
    private MateriViewModel materiViewModel;
    private RecyclerView recyclerView;
    private MateriAdapter materiAdapter;
    private String katId;
    private String katNama;
    private String katDesk;
    private String programId;
    private String namaProgram;
    private static String KKId;
    private static String namaKK;
    private static String deskKK;
    private String prodiId;
    private String prodiNama;

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
            katId = getArguments().getString("kategori_id");
            katNama = getArguments().getString("nama_kategori");
            katDesk = getArguments().getString("desk_kategori");
            programId = getArguments().getString("program_id");
            namaProgram = getArguments().getString("nama_program");
            KKId = getArguments().getString("kk_id");
            namaKK = getArguments().getString("nama_kk");
            deskKK = getArguments().getString("desk_kk");
            prodiId = getArguments().getString("prodi_id");
            prodiNama = getArguments().getString("nama_prodi");
            TextView txvProdi = view.findViewById(R.id.header_title);
            txvProdi.setText(katNama);
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        materiAdapter = new MateriAdapter();
        recyclerView.setAdapter(materiAdapter);

        materiViewModel = new ViewModelProvider(this).get(MateriViewModel.class);

        // Panggil metode ViewModel dengan prodiId
        materiViewModel.loadListMateriByKategori(katId);
        materiViewModel = new ViewModelProvider(this).get(MateriViewModel.class);
        materiViewModel.getListMateri().observe(getViewLifecycleOwner(), new Observer<List<MateriModel>>() {
            @Override
            public void onChanged(List<MateriModel> materiViewVOS) {
                materiAdapter.setMateriList(materiViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KategoriFragment kategoriFragment = KategoriFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("program_id", programId);
                args.putString("nama_program", namaProgram);
                args.putString("kk_id", KKId);
                args.putString("nama_kk", namaKK);
                args.putString("desk_kk", deskKK);
                args.putString("prodi_id", prodiId);
                args.putString("nama_prodi", prodiNama);
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

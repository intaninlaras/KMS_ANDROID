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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.KategoriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.KategoriViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.MateriTersimpanViewModel;

import java.util.ArrayList;
import java.util.List;

public class KategoriFragment extends Fragment {
    private KategoriViewModel kategoriViewModel;
    private RecyclerView recyclerView;
    private KategoriAdapter kategoriAdapter;

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

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        kategoriAdapter = new KategoriAdapter();
        recyclerView.setAdapter(kategoriAdapter);

        kategoriViewModel = new ViewModelProvider(this).get(KategoriViewModel.class);
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
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new ProgramFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private static class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {
        private List<KategoriModel> kategoriList = new ArrayList<>();

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

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Ganti fragment saat ini dengan ProgramFragment dan kirim data ProdiModel
                    MateriFragment materiFragment = MateriFragment.newInstance();
                    FragmentTransaction transaction = ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, materiFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
//            String deskripsi = materi.getKeterangan();
//            if (deskripsi.length() > 100) {
//                deskripsi = deskripsi.substring(0, 100) + "...";
//            }
//            holder.keterangan.setText(deskripsi);

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
            TextView judul, keterangan;

            public KategoriViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                keterangan = itemView.findViewById(R.id.deskripsi);
            }
        }
    }
}

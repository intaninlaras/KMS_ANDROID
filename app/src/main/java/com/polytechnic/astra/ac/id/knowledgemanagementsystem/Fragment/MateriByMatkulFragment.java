package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.MateriByMatkulViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.MateriTersimpanViewModel;

import java.util.ArrayList;
import java.util.List;

public class MateriByMatkulFragment extends Fragment {
    private MateriByMatkulViewModel materiViewModel;
    private RecyclerView recyclerView;
    private MateriAdapter materiAdapter;

    public static MateriByMatkulFragment newInstance() {
        return new MateriByMatkulFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_materi_bymatkul, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        materiAdapter = new MateriAdapter();
        recyclerView.setAdapter(materiAdapter);

        materiViewModel = new ViewModelProvider(this).get(MateriByMatkulViewModel.class);
        materiViewModel.getListMateri().observe(getViewLifecycleOwner(), new Observer<List<MateriViewVO>>() {
            @Override
            public void onChanged(List<MateriViewVO> materiViewVOS) {
                materiAdapter.setMateriList(materiViewVOS);
            }
        });


    }

    private static class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
        private List<MateriViewVO> materiList = new ArrayList<>();

        @NonNull
        @Override
        public MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materi, parent, false);
            return new MateriViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MateriViewHolder holder, int position) {
            MateriViewVO materi = materiList.get(position);
            holder.judul.setText(materi.getJudul());
            holder.keterangan.setText(materi.getKeterangan());

//            String deskripsi = materi.getKeterangan();
//            if (deskripsi.length() > 100) {
//                deskripsi = deskripsi.substring(0, 100) + "...";
//            }
//            holder.keterangan.setText(deskripsi);

        }

        @Override
        public int getItemCount() {
            return materiList.size();
        }

        public void setMateriList(List<MateriViewVO> materiList) {
            this.materiList = materiList;
            notifyDataSetChanged();
        }

        static class MateriViewHolder extends RecyclerView.ViewHolder {
            TextView judul, keterangan;

            public MateriViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                keterangan = itemView.findViewById(R.id.deskripsi);
            }
        }
    }
}

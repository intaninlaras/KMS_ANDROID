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

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.MateriTersimpanViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.RiwayatMateriViewModel;

import java.util.ArrayList;
import java.util.List;

public class RiwayatMateriFragment extends Fragment {
    private RiwayatMateriViewModel materiViewModel;
    private RecyclerView recyclerView;
    private MateriAdapter materiAdapter;

    public static RiwayatMateriFragment newInstance() {
        return new RiwayatMateriFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_riwayat_pengguna, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        materiAdapter = new MateriAdapter();
        recyclerView.setAdapter(materiAdapter);

        materiViewModel = new ViewModelProvider(this).get(RiwayatMateriViewModel.class);
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
                // Ganti fragment saat ini dengan RiwayatMateriFragment
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment());
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

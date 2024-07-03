package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.KKViewModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.ProgramViewModel;

import java.util.ArrayList;
import java.util.List;

public class KKFragment extends Fragment {
    private KKViewModel kkViewModel;
    private RecyclerView recyclerView;
    private KKAdapter kkAdapter;
    private String prodiId;
    private String prodiNama;
    private String kkId;
    private String namaKK;
    private String deskKK;

    public static KKFragment newInstance() {
        return new KKFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            prodiId = getArguments().getString("prodi_id");
            prodiNama = getArguments().getString("nama_prodi");
            kkId = getArguments().getString("kk_id");
            namaKK = getArguments().getString("nama_kk");
            deskKK = getArguments().getString("desk_kk");

            TextView txvProdi = view.findViewById(R.id.txv_prodi);
            txvProdi.setText(prodiNama);
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        kkAdapter = new KKAdapter(getParentFragmentManager(), prodiId);
        recyclerView.setAdapter(kkAdapter);

        kkViewModel = new ViewModelProvider(this).get(KKViewModel.class);

        // Panggil metode ViewModel dengan prodiId
        kkViewModel.loadListKKByProdi(prodiId);

        kkViewModel.getListKK().observe(getViewLifecycleOwner(), new Observer<List<KKModel>>() {
            @Override
            public void onChanged(List<KKModel> kkViewVOS) {
                kkAdapter.setKKList(kkViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    public class KKAdapter extends RecyclerView.Adapter<KKAdapter.KKViewHolder> {
        private List<KKModel> kkList = new ArrayList<>();
        private FragmentManager fragmentManager;

        public KKAdapter(FragmentManager fragmentManager, String prodiId) {
            this.fragmentManager = fragmentManager;
        }

        @NonNull
        @Override
        public KKViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_program, parent, false);
            return new KKViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull KKViewHolder holder, int position) {
            KKModel kk = kkList.get(position);
            holder.judul.setText(kk.getKkeNama());
            holder.keterangan.setText(kk.getKkeDeskripsi());
            holder.arrowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgramFragment programFragment = ProgramFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("kk_id", kk.getKkeId());
                    args.putString("nama_kk", kk.getKkeNama());
                    args.putString("desk_kk", kk.getKkeDeskripsi());
                    programFragment.setArguments(args);
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container, programFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return kkList.size();
        }

        public void setKKList(List<KKModel> kkList) {
            this.kkList = kkList;
            notifyDataSetChanged();
        }

        public class KKViewHolder extends RecyclerView.ViewHolder {
            TextView judul, keterangan;
            Button arrowButton;

            public KKViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                keterangan = itemView.findViewById(R.id.deskripsi);
                arrowButton = itemView.findViewById(R.id.matkulButton);
            }
        }
    }
}

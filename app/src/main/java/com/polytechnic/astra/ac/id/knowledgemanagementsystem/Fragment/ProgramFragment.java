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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.ProgramViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.ProgramViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramFragment extends Fragment {
    private ProgramViewModel programViewModel;
    private RecyclerView recyclerView;
    private ProgramAdapter programAdapter;
    private String kkId;
    private String prodiId;
    private String namaKK;
    private String deskKK;

    public static ProgramFragment newInstance() {
        return new ProgramFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_program, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            kkId = getArguments().getString("kk_id");
            prodiId = getArguments().getString("prodi_id");
            namaKK = getArguments().getString("nama_kk");
            deskKK = getArguments().getString("desk_kk");
            TextView txvNama = view.findViewById(R.id.txv_namaProgram);
            TextView txvDesk = view.findViewById(R.id.txv_deskProgram);
            txvDesk.setText(deskKK);
            txvNama.setText(namaKK);
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        programAdapter = new ProgramAdapter(getParentFragmentManager());
        recyclerView.setAdapter(programAdapter);

        programViewModel = new ViewModelProvider(this).get(ProgramViewModel.class);
        programViewModel.loadListProdiByKK(kkId);
        programViewModel.getListProgram().observe(getViewLifecycleOwner(), new Observer<List<ProgramModel>>() {
            @Override
            public void onChanged(List<ProgramModel> programViewVOS) {
                programAdapter.setProgramList(programViewVOS);
            }
        });

        ImageButton back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KKFragment kkFragment = KKFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("prodi_id", prodiId);
                args.putString("kk_id", kkId);
                args.putString("nama_kk", namaKK);
                args.putString("desk_kk", deskKK);
                kkFragment.setArguments(args);
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, kkFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {
        private List<ProgramModel> programList = new ArrayList<>();
        private FragmentManager fragmentManager;

        public ProgramAdapter(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
        }

        @NonNull
        @Override
        public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_program, parent, false);
            return new ProgramViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
            ProgramModel program = programList.get(position);
            holder.judul.setText(program.getProNama());
            holder.keterangan.setText(program.getProDeskripsi());

            holder.arrowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KategoriFragment kategoriFragment = KategoriFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("program_id", program.getProId());
                    kategoriFragment.setArguments(args);
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container, kategoriFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return programList.size();
        }

        public void setProgramList(List<ProgramModel> programList) {
            this.programList = programList;
            notifyDataSetChanged();
        }

        public class ProgramViewHolder extends RecyclerView.ViewHolder {
            TextView judul, keterangan;
            Button arrowButton;

            public ProgramViewHolder(@NonNull View itemView) {
                super(itemView);
                judul = itemView.findViewById(R.id.judul);
                keterangan = itemView.findViewById(R.id.deskripsi);
                arrowButton = itemView.findViewById(R.id.matkulButton);
            }
        }
    }
}

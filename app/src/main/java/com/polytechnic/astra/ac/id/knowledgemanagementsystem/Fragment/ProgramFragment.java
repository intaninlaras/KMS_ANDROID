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

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.R;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel.ProgramViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramFragment extends Fragment {
    private ProgramViewModel mProgramViewModel;
    private RecyclerView mRecyclerView;
    private ProgramAdapter mProgramAdapter;
    private String mKKId;
    private String mProdiId;
    private String mProdiNama;

    private String mNamaKK;
    private String mDeskKK;
    private ImageButton mBtnBack;

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
            mKKId = getArguments().getString("kk_id");
            mProdiId = getArguments().getString("prodi_id");
            mProdiNama = getArguments().getString("nama_prodi");
            mNamaKK = getArguments().getString("nama_kk");
            mDeskKK = getArguments().getString("desk_kk");
            TextView txvNama = view.findViewById(R.id.txv_namaKK);
            TextView txvDesk = view.findViewById(R.id.txv_deskKK);
            txvNama.setText(mNamaKK);
            txvDesk.setText(mDeskKK);
        }

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mProgramAdapter = new ProgramAdapter(getParentFragmentManager(), mKKId, mNamaKK, mDeskKK);
        mRecyclerView.setAdapter(mProgramAdapter);

        mProgramViewModel = new ViewModelProvider(this).get(ProgramViewModel.class);
        mProgramViewModel.loadListProgramByKK(mKKId);
        mProgramViewModel.getListProgram().observe(getViewLifecycleOwner(), new Observer<List<ProgramModel>>() {
            @Override
            public void onChanged(List<ProgramModel> programViewVOS) {
                mProgramAdapter.setProgramList(programViewVOS);
            }
        });

        mBtnBack = view.findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KKFragment kkFragment = KKFragment.newInstance();
                Bundle args = new Bundle();
                args.putString("prodi_id", mProdiId);
                args.putString("nama_prodi", mProdiNama);
                args.putString("kk_id", mKKId);
                args.putString("nama_kk", mNamaKK);
                args.putString("desk_kk", mDeskKK);
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
        private FragmentManager mFragmentManager;
        private String mKKId;
        private String mNamaKK;
        private String mDeskKK;

        public ProgramAdapter(FragmentManager fragmentManager, String mKKId, String mNamaKK, String mDeskKK) {
            this.mFragmentManager = fragmentManager;
            this.mKKId = mKKId;
            this.mNamaKK = mNamaKK;
            this.mDeskKK = mDeskKK;
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
            holder.mTxvNamaProgram.setText(program.getProNama());
            holder.mTxvDeskProgram.setText(program.getProDeskripsi());

            holder.mBtnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    KategoriFragment kategoriFragment = KategoriFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("program_id", program.getProId());
                    args.putString("nama_program", program.getProNama());
                    args.putString("desk_program", program.getProDeskripsi());
                    args.putString("kk_id", mKKId);
                    args.putString("nama_kk", mNamaKK);
                    args.putString("desk_kk", mDeskKK);
                    args.putString("prodi_id", mProdiId);
                    args.putString("nama_prodi", mProdiNama);
                    kategoriFragment.setArguments(args);
                    FragmentTransaction transaction = mFragmentManager.beginTransaction();
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
            TextView mTxvNamaProgram, mTxvDeskProgram;
            Button mBtnNext;

            public ProgramViewHolder(@NonNull View itemView) {
                super(itemView);
                mTxvNamaProgram = itemView.findViewById(R.id.txv_namaProgram);
                mTxvDeskProgram = itemView.findViewById(R.id.txv_deskProgram);
                mBtnNext = itemView.findViewById(R.id.btn_next);
            }
        }
    }
}

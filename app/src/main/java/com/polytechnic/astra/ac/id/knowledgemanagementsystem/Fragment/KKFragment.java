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
    private KKViewModel mKKViewModel;
    private RecyclerView mRecyclerView;
    private KKAdapter mKKAdapter;
    private ImageButton mBtnBack;
    private String mProdiId;
    private String mProdiNama;
    private String mKKId;
    private String mNamaKK;
    private String mDeskKK;

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
            mProdiId = getArguments().getString("prodi_id");
            mProdiNama = getArguments().getString("nama_prodi");
            mKKId = getArguments().getString("kk_id");
            mNamaKK = getArguments().getString("nama_kk");
            mDeskKK = getArguments().getString("desk_kk");

            TextView txvProdi = view.findViewById(R.id.txv_prodi);
            txvProdi.setText(mProdiNama);
        }

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mKKAdapter = new KKAdapter(getParentFragmentManager(), mProdiId);
        mRecyclerView.setAdapter(mKKAdapter);

        mKKViewModel = new ViewModelProvider(this).get(KKViewModel.class);

        // Panggil metode ViewModel dengan mProdiId
        mKKViewModel.loadListKKByProdi(mProdiId);

        mKKViewModel.getListKK().observe(getViewLifecycleOwner(), new Observer<List<KKModel>>() {
            @Override
            public void onChanged(List<KKModel> kkViewVOS) {
                mKKAdapter.setKKList(kkViewVOS);
            }
        });

        mBtnBack = view.findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
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

        public KKAdapter(FragmentManager fragmentManager, String mProdiId) {
            this.fragmentManager = fragmentManager;
        }

        @NonNull
        @Override
        public KKViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kk, parent, false);
            return new KKViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull KKViewHolder holder, int position) {
            KKModel kk = kkList.get(position);
            holder.mTxvNamaKK.setText(kk.getKkeNama());
            holder.mTxvDeskKK.setText(kk.getKkeDeskripsi());
            holder.mBtnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ProgramFragment programFragment = ProgramFragment.newInstance();
                    Bundle args = new Bundle();
                    args.putString("kk_id", kk.getKkeId());
                    args.putString("nama_kk", kk.getKkeNama());
                    args.putString("desk_kk", kk.getKkeDeskripsi());
                    args.putString("prodi_id", mProdiId);
                    args.putString("nama_prodi", mProdiNama);
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
            TextView mTxvNamaKK, mTxvDeskKK;
            Button mBtnNext;

            public KKViewHolder(@NonNull View itemView) {
                super(itemView);
                mTxvNamaKK = itemView.findViewById(R.id.txv_namaKK);
                mTxvDeskKK = itemView.findViewById(R.id.txv_deskKK);
                mBtnNext = itemView.findViewById(R.id.btn_nextKK);
            }
        }
    }
}

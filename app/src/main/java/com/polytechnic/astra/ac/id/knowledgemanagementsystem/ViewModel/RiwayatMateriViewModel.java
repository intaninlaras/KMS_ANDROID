package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;

import java.util.ArrayList;
import java.util.List;

public class RiwayatMateriViewModel extends ViewModel {
    private MutableLiveData<List<MateriModel>> mListMateri;
    private MyRepository mMyRepository;

    public RiwayatMateriViewModel() {
        mMyRepository = MyRepository.get();
    }
    public MutableLiveData<List<MateriModel>> getListRiwayatMateri(String kry_id){
        mListMateri = mMyRepository.findAllRiwayatMateri(kry_id);
        return mListMateri;
    }
}


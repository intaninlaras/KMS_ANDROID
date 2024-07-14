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

public class MateriTersimpanViewModel extends ViewModel {
    private MutableLiveData<List<MateriModel>> mListMateri;
    private MyRepository mMyRepository;

    public MateriTersimpanViewModel() {
        mMyRepository = MyRepository.get();
        mListMateri = new MutableLiveData<>();
    }
    public MutableLiveData<List<MateriModel>> getListMateri(String kry_id){
        mListMateri = mMyRepository.findAllRiwayatMateri(kry_id);
        return mListMateri;
    }
}


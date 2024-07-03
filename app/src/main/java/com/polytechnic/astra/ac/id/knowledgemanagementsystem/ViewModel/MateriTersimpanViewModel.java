package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;

import java.util.ArrayList;
import java.util.List;

public class MateriTersimpanViewModel extends ViewModel {
    private MutableLiveData<List<MateriModel>> listMateri;
    private MyRepository prodiRepository;

    public MateriTersimpanViewModel() {
        prodiRepository = MyRepository.get();
        listMateri = prodiRepository.getListRiwayatMateri("0320220086");
    }
    public LiveData<List<MateriModel>> getListMateri() {
        return listMateri;
    }
}


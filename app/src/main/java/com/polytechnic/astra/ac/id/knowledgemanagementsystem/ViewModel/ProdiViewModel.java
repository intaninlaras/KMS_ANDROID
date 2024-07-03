package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;

import java.util.List;

public class ProdiViewModel extends ViewModel {
    private LiveData<List<ProdiModel>> listProdi;
    private MyRepository prodiRepository;

    public ProdiViewModel() {
//        ProdiRepository.initialize(application);
        prodiRepository = MyRepository.get();
        listProdi = prodiRepository.getListProdi();
    }

    public LiveData<List<ProdiModel>> getListProdi() {
        return listProdi;
    }
}

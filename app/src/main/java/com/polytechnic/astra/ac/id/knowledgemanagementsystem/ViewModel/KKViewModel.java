package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;

import java.util.List;

public class KKViewModel extends ViewModel {
    private MutableLiveData<List<KKModel>> listKK;
    private MyRepository prodiRepository;

    public KKViewModel() {
        prodiRepository = MyRepository.get();
        listKK = new MutableLiveData<>();
//        loadListKKByProdi(prodiId);
    }

    public void loadListKKByProdi(String prodiId) {
        listKK = prodiRepository.getListDataKKByProdi(prodiId);
    }

    public LiveData<List<KKModel>> getListKK() {
        return listKK;
    }
}

package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;

import java.util.List;

public class ProdiViewModel extends ViewModel {
    private MutableLiveData<List<ProdiModel>> mListProdi;
    private MyRepository mMyRepository;

    public ProdiViewModel() {
        mMyRepository = MyRepository.get();
    }

    public MutableLiveData<List<ProdiModel>> getListProdi(){
        mListProdi = mMyRepository.findAllProdi();
        return mListProdi;
    }
}

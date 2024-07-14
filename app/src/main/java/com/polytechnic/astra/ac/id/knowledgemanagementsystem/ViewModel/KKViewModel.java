package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;

import java.util.List;

public class KKViewModel extends ViewModel {
    private MutableLiveData<List<KKModel>> mListKK;
    private MyRepository mMyRepository;

    public KKViewModel() {
        mMyRepository = MyRepository.get();
        mListKK = new MutableLiveData<>();
    }

    public MutableLiveData<List<KKModel>> loadListKKByProdi(String pro_id){
        mListKK = mMyRepository.findAllKKbyProdi(pro_id);
        return mListKK;
    }

    public LiveData<List<KKModel>> getListKK() {
        return mListKK;
    }
}

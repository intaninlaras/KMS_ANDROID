package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.List;

public class MateriViewModel extends ViewModel {
    private MutableLiveData<List<MateriModel>> mListMateri;
    private MyRepository mMyRepository;

    public MateriViewModel() {
        mMyRepository = MyRepository.get();
        mListMateri = new MutableLiveData<>();
    }

    public MutableLiveData<List<MateriModel>> loadListMateriByKategori(String kat_id){
        mListMateri = mMyRepository.findAllMateriByKategori(kat_id);
        return mListMateri;
    }
    public LiveData<List<MateriModel>> getListMateri() {
        return mListMateri;
    }
}

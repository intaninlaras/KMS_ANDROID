package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.List;

public class MateriViewModel extends ViewModel {
    private MutableLiveData<List<MateriModel>> getListMateri;
    private MyRepository prodiRepository;

    public MateriViewModel() {
        prodiRepository = MyRepository.get();
        getListMateri = prodiRepository.getListDataMateriByKategori("1");
    }

    public LiveData<List<MateriModel>> getListMateri() {
        return getListMateri;
    }
}

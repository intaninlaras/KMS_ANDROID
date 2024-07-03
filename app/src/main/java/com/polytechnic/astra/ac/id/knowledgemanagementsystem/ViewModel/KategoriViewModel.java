package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.KategoriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;

import java.util.ArrayList;
import java.util.List;

public class KategoriViewModel extends ViewModel {
    private MutableLiveData<List<KategoriModel>> listKategori;
    private MyRepository prodiRepository;
    public KategoriViewModel() {
        prodiRepository = MyRepository.get();
        listKategori = new MutableLiveData<>();
//        listKategori = prodiRepository.getListDataKategoriByProgram("1");

    }
    public void loadListKategoriByProgram(String programId) {
        listKategori = prodiRepository.getListDataKategoriByProgram(programId);
    }

    public LiveData<List<KategoriModel>> getListKategori() {
        return listKategori;
    }
}

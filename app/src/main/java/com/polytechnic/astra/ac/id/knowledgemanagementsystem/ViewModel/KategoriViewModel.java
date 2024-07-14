package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.KategoriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.ArrayList;
import java.util.List;

public class KategoriViewModel extends ViewModel {
    private MutableLiveData<List<KategoriModel>> mListKategori;
    private MyRepository mMyRepository;
    public KategoriViewModel() {
        mMyRepository = MyRepository.get();
        mListKategori = new MutableLiveData<>();
    }
    public MutableLiveData<List<KategoriModel>> loadListKategoriByProgram(String pro_id){
        mListKategori = mMyRepository.findAllKategoribyProgram(pro_id);
        return mListKategori;
    }

    public LiveData<List<KategoriModel>> getListKategori() {
        return mListKategori;
    }
}

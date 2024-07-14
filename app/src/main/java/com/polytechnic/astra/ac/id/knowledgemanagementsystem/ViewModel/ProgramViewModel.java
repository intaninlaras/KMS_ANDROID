package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.ProgramViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramViewModel extends ViewModel {
    private MutableLiveData<List<ProgramModel>> mListProgram;
    private MyRepository mMyRepository;

    public ProgramViewModel() {
        mMyRepository = MyRepository.get();
        mListProgram = new MutableLiveData<>();
    }
    public MutableLiveData<List<ProgramModel>> loadListProgramByKK(String kke_id){
        mListProgram = mMyRepository.findAllProgrambyKK(kke_id);
        return mListProgram;
    }
    public LiveData<List<ProgramModel>> getListProgram() {
        return mListProgram;
    }
}

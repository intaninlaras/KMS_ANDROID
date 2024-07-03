package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.ProgramViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.ArrayList;
import java.util.List;

public class ProgramViewModel extends ViewModel {
    private MutableLiveData<List<ProgramModel>> listProgram;
    private MyRepository prodiRepository;

    public ProgramViewModel() {
        prodiRepository = MyRepository.get();
        listProgram = new MutableLiveData<>();
//        listProgram = prodiRepository.getListDataProgramByKK("002");
    }
    public void loadListProdiByKK(String kkId) {
        listProgram = prodiRepository.getListDataProgramByKK(kkId);
    }
    public LiveData<List<ProgramModel>> getListProgram() {
        return listProgram;
    }

//    private void loadDummyData() {
//        List<ProgramModel> dummyProgramList = new ArrayList<>();
//
//        // Generate dummy data
//        dummyProgramList.add(new ProgramModel("1", "Program Manajemen Informatika", "Program studi untuk mengelola informasi dan teknologi."));
//        dummyProgramList.add(new ProgramModel("2", "Program Mekatronika", "Program studi yang mengintegrasikan mekanika, elektronika, dan otomasi."));
//        dummyProgramList.add(new ProgramModel("3", "Program Mesin Otomotif", "Program studi yang mempelajari teknologi mesin otomotif dan kendaraan bermotor."));
//
//        listProgram.setValue(dummyProgramList);
//    }
}

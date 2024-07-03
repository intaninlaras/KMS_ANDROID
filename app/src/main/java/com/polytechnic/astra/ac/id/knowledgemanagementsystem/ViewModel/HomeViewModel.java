package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MateriViewVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private RiwayatMateriViewModel riwayatMateriViewModel;
    private MateriTersimpanViewModel materiTersimpanViewModel;
    private ProdiViewModel listProdiViewModel;

    public HomeViewModel() {
        riwayatMateriViewModel = new RiwayatMateriViewModel();
        materiTersimpanViewModel = new MateriTersimpanViewModel();
        listProdiViewModel = new ProdiViewModel();
    }

    public LiveData<List<MateriModel>> getRiwayatMateri() {
        return riwayatMateriViewModel.getListMateri();
    }

    public LiveData<List<MateriModel>> getMateriTersimpan() {
        return materiTersimpanViewModel.getListMateri();
    }

    public LiveData<List<ProdiModel>> getListProdi() {
        return listProdiViewModel.getListProdi();
    }
}

package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.PKRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.PKModel;

import java.util.List;

public class PKViewModel extends ViewModel {
    private MutableLiveData<List<PKModel>> mMyModelListMutableLiveData;
    private PKRepository mPKRepository;
    public PKViewModel(){
        mPKRepository = PKRepository.get();
//        mMyModelListMutableLiveData = mProdiRepository.getListProdi();
        mMyModelListMutableLiveData = mPKRepository.getListPK();
    }
    public MutableLiveData<List<PKModel>> getListModel(){
        return mMyModelListMutableLiveData;
    }

}

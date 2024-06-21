package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.MyRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MyModel;

import java.util.List;

public class MyListViewModel extends ViewModel {

    private MutableLiveData<List<MyModel>> mMyModelListMutableLiveData;
    private MyRepository mMyRepository;
    public MyListViewModel(){
        mMyRepository = MyRepository.get();
        mMyModelListMutableLiveData = mMyRepository.getMyListModel();
    }
    public MutableLiveData<List<MyModel>> getListModel(){
        return mMyModelListMutableLiveData;
    }


}

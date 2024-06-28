package com.polytechnic.astra.ac.id.knowledgemanagementsystem.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository.LoginRepository;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.LoginModel;

import java.util.List;

public class LoginViewModel  extends ViewModel {
    private MutableLiveData<List<LoginModel>> mMyModelListMutableLiveData;
    private LoginRepository mLoginRepository;
    public LoginViewModel(){
        mLoginRepository = LoginRepository.get();
        mMyModelListMutableLiveData = mLoginRepository.getLogin();
    }
    public MutableLiveData<List<LoginModel>> getLogin(){
        return mMyModelListMutableLiveData;
    }
}

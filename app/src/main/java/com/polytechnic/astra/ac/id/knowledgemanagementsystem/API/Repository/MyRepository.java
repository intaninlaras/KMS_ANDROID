package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.ApiUtils;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.MyService;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO.MyVO;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MyRepository {
    private static String API_KEY = "hXvaLzrPm8oVcFT+GXpLKA==DWpsB3870esnmIps";
    private static final String TAG = "MyRepository";
    private static MyRepository INSTANCE;
    private MyService mMyService;
    private MyRepository(Context context){
        mMyService = ApiUtils.getMyService();
    }
    public static void initialize(Context context){
        if (INSTANCE == null){
            INSTANCE = new MyRepository(context);
        }
    }
    public static MyRepository get(){
        return INSTANCE;
    }

    public MutableLiveData<List<MyModel>> getMyListModel(){
        MutableLiveData<List<MyModel>> data = new MutableLiveData<>();
        Call<List<MyModel>> call = mMyService.getMyModel(API_KEY,"Cat");
        call.enqueue(new Callback<List<MyModel>>() {
            @Override
            public void onResponse(Call<List<MyModel>> call, Response<List<MyModel>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Log.d(TAG,data.getValue().size()+"");
                }
            }

            @Override
            public void onFailure(Call<List<MyModel>> call, Throwable t) {
                Log.e("Error API call : ", t.getMessage());
            }
        });
        return data;
    }


    public MutableLiveData<List<MyVO>> getMyListVO(){
        MutableLiveData<List<MyVO>> data = new MutableLiveData<>();
        Call<List<MyVO>> call = mMyService.getMyVO();
        call.enqueue(new Callback<List<MyVO>>() {
            @Override
            public void onResponse(Call<List<MyVO>> call, Response<List<MyVO>> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<MyVO>> call, Throwable t) {
                Log.e("Error API call : ", t.getMessage());
            }
        });
        return data;
    }
}

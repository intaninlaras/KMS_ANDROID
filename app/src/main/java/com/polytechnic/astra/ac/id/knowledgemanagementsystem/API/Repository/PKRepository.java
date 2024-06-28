package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.ApiUtils;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.PKService;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.PKModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PKRepository {
    private static final String TAG = "PKRepository";
    private static PKRepository INSTANCE;
    private PKService mPKService;
    private PKRepository(Context context){
        mPKService = ApiUtils.getPKService();
    }
    public static void initialize(Context context){
        if (INSTANCE == null){
            INSTANCE = new PKRepository(context);
        }
    }
    public static PKRepository get(){
        return INSTANCE;
    }
    public MutableLiveData<List<PKModel>> getListPK() {
        MutableLiveData<List<PKModel>> data = new MutableLiveData<>();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "{ \"page\": 1, \"query\": \"\", \"sort\": \"[Nama Kelompok Keahlian] asc\" }");
        System.out.println(body.contentType());
        Call<ResponseBody> call = mPKService.getDataPK(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        String jsonString = response.body().string();
                        JSONArray jsonArray = new JSONArray(jsonString);

                        List<PKModel> PKList = new ArrayList<>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject PKObject = jsonArray.getJSONObject(i);
                            PKModel PK = new PKModel();
                            PK.setKey(PKObject.getString("Key"));
                            PK.setNamaKelompokKeahlian(PKObject.getString("Nama Kelompok Keahlian"));
                            if(PKObject.getString("Deskripsi").length() > 30){
                                PK.setDeskripsi(PKObject.getString("Deskripsi").substring(0,20)+ " ...");
                            }else{
                                PK.setDeskripsi(PKObject.getString("Deskripsi"));
                            }
//                            PK.setDeskripsi(PKObject.getString("Deskripsi"));
                            PKList.add(PK);
                        }
                        data.setValue(PKList);
                        Log.d(TAG, "Data size: " + PKList.size());
                    } catch (Exception e) {
                        Log.e(TAG, "Error parsing JSON", e);
                    }
                } else {
                    // Tangani kesalahan respon
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Error API call : ", t.getMessage());
            }
        });
        return data;
    }
}

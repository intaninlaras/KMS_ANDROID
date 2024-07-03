package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.ApiUtils;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.MyService;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {
    private static final String COOKIE = "_ga=GA1.1.1011038483.1702824372; cookie=%7B%22kry_id%22%3A%222%22%2C%22apk_id%22%3A%222%22%2C%22rol_id%22%3A%222%22%7D; ci_session=nm1lunbpb26hbqq99j4t233au787fndp";
    private static final String ACCEPT = "application/json";
    private static final String TAG = "ProdiRepository";
    private static MyRepository INSTANCE;
    private MyService mProdiService;

    private MyRepository(Context context) {
        mProdiService = ApiUtils.getProdiService();
    }

    public static synchronized void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MyRepository(context.getApplicationContext());
        }
    }

    public static MyRepository get() {
        return INSTANCE;
    }
    public MutableLiveData<List<ProdiModel>> getListProdi() {
        MutableLiveData<List<ProdiModel>> data = new MutableLiveData<>();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), "{}");
        Call<List<ProdiModel>> call = mProdiService.getDataProdi(COOKIE, ACCEPT, body);        call.enqueue(new Callback<List<ProdiModel>>() {
            @Override
            public void onResponse(Call<List<ProdiModel>> call, Response<List<ProdiModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ProdiModel> prodiViewList = new ArrayList<>();
                    for (ProdiModel prodiModel : response.body()) {
                        ProdiModel prodiView = new ProdiModel();
                        prodiView.setValue(prodiModel.getValue());
                        prodiView.setText(prodiModel.getText());
//                        prodiView.setText(prodiModel.getDeskripsi());
                        prodiViewList.add(prodiView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<ProdiModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }

    public MutableLiveData<List<MateriModel>> getListRiwayatMateri(String kryId) {
        MutableLiveData<List<MateriModel>> data = new MutableLiveData<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("p1", kryId);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<List<MateriModel>> call = mProdiService.getRiwayatMateri(COOKIE, ACCEPT, body);
        call.enqueue(new Callback<List<MateriModel>>() {
            @Override
            public void onResponse(Call<List<MateriModel>> call, Response<List<MateriModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MateriModel> prodiViewList = new ArrayList<>();
                    for (MateriModel materiModel : response.body()) {
                        MateriModel materiView = new MateriModel();
                        materiView.setMatId(materiModel.getMatId());
                        materiView.setMatJudul(materiModel.getMatJudul());
                        materiView.setMatKeterangan(materiModel.getMatKeterangan());
                        prodiViewList.add(materiView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<MateriModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }

    public MutableLiveData<List<KKModel>> getListDataKKByProdi(String proId) {
        MutableLiveData<List<KKModel>> data = new MutableLiveData<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("p1", proId);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<List<KKModel>> call = mProdiService.getDataKKByProdi(COOKIE,ACCEPT,body);
        call.enqueue(new Callback<List<KKModel>>() {
            @Override
            public void onResponse(Call<List<KKModel>> call, Response<List<KKModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<KKModel> prodiViewList = new ArrayList<>();
                    for (KKModel KKModel : response.body()) {
                        KKModel KKView = new KKModel();
                        KKView.setKkeId(KKModel.getKkeId());
                        KKView.setKkeNama(KKModel.getKkeNama());
                        KKView.setKkeDeskripsi(KKModel.getKkeDeskripsi());
                        KKView.setProNama(KKModel.getProNama());
                        prodiViewList.add(KKView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<KKModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }

    public MutableLiveData<List<ProgramModel>> getListDataProgramByKK(String kkId) {
        MutableLiveData<List<ProgramModel>> data = new MutableLiveData<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("p1", kkId);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<List<ProgramModel>> call = mProdiService.getDataProgramByKK(COOKIE,ACCEPT,body);
        call.enqueue(new Callback<List<ProgramModel>>() {
            @Override
            public void onResponse(Call<List<ProgramModel>> call, Response<List<ProgramModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ProgramModel> prodiViewList = new ArrayList<>();
                    for (ProgramModel programModel : response.body()) {
                        ProgramModel KKView = new ProgramModel();
                        KKView.setProId(programModel.getProId());
                        KKView.setProNama(programModel.getProNama());
                        KKView.setProDeskripsi(programModel.getProDeskripsi());
                        prodiViewList.add(KKView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<ProgramModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }
    public MutableLiveData<List<KategoriModel>> getListDataKategoriByProgram(String proId) {
        MutableLiveData<List<KategoriModel>> data = new MutableLiveData<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("p1", proId);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<List<KategoriModel>> call = mProdiService.getDataKategoriByProgram(COOKIE,ACCEPT,body);
        call.enqueue(new Callback<List<KategoriModel>>() {
            @Override
            public void onResponse(Call<List<KategoriModel>> call, Response<List<KategoriModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<KategoriModel> prodiViewList = new ArrayList<>();
                    for (KategoriModel programModel : response.body()) {
                        KategoriModel KKView = new KategoriModel();
                        KKView.setKatId(programModel.getKatId());
                        KKView.setKatNama(programModel.getKatNama());
                        KKView.setKatDeskripsi(programModel.getKatDeskripsi());
                        prodiViewList.add(KKView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<KategoriModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }
    public MutableLiveData<List<MateriModel>> getListDataMateriByKategori(String proId) {
        MutableLiveData<List<MateriModel>> data = new MutableLiveData<>();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("p1", proId);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
        Call<List<MateriModel>> call = mProdiService.getDataMateriByKategori(COOKIE,ACCEPT,body);
        call.enqueue(new Callback<List<MateriModel>>() {
            @Override
            public void onResponse(Call<List<MateriModel>> call, Response<List<MateriModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MateriModel> prodiViewList = new ArrayList<>();
                    for (MateriModel programModel : response.body()) {
                        MateriModel KKView = new MateriModel();
                        KKView.setMatId(programModel.getMatId());
                        KKView.setMatJudul(programModel.getMatJudul());
                        KKView.setMatKeterangan(programModel.getMatKeterangan());
                        prodiViewList.add(KKView);
                    }
                    data.setValue(prodiViewList);
                    Log.d(TAG, "Data size: " + prodiViewList.size());
                } else {
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<List<MateriModel>> call, Throwable t) {
                Log.e(TAG, "Error API call: " + t.getMessage());
            }
        });
        return data;
    }
}

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
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {
    private static final String COOKIE = "_ga=GA1.1.1011038483.1702824372; cookie=%7B%22kry_id%22%3A%222%22%2C%22apk_id%22%3A%222%22%2C%22rol_id%22%3A%222%22%7D; ci_session=nm1lunbpb26hbqq99j4t233au787fndp";
    private static final String ACCEPT = "application/json";
    private static final String TAG = "MyRepository";
    private static MyRepository INSTANCE;
    private MyService mMyService;

    private MyRepository(Context context) {
        mMyService = ApiUtils.getProdiService();
    }

    public static synchronized void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MyRepository(context.getApplicationContext());
        }
    }

    public static MyRepository get() {
        return INSTANCE;
    }
    //List Prodi
    public MutableLiveData<List<ProdiModel>> findAllProdi() {
        MutableLiveData<List<ProdiModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.findallprodi();
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<ProdiModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        ProdiModel mahasiswaVO = new ProdiModel(
                                mahasiswa.get("pro_id"),
                                mahasiswa.get("pro_nama")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }
                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    //List Riwayat Materi
    public MutableLiveData<List<MateriModel>> findAllRiwayatMateri(String kry_id) {
        MutableLiveData<List<MateriModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.getAllRiwayatMateri(kry_id);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<MateriModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        MateriModel mahasiswaVO = new MateriModel(
                                mahasiswa.get("mat_id"),
                                mahasiswa.get("kat_id"),
                                mahasiswa.get("mat_judul"),
                                mahasiswa.get("mat_file_pdf"),
                                mahasiswa.get("mat_file_video"),
                                mahasiswa.get("mat_pengenalan"),
                                mahasiswa.get("mat_keterangan")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }
                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    //List KK Berdasarkan Prodi
    public MutableLiveData<List<KKModel>> findAllKKbyProdi(String pro_id) {
        MutableLiveData<List<KKModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.getAllKKByProdi(pro_id);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<KKModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        KKModel mahasiswaVO = new KKModel(
                                mahasiswa.get("kke_id"),
                                mahasiswa.get("kke_nama"),
                                mahasiswa.get("pro_id"),
                                mahasiswa.get("kry_id"),
                                mahasiswa.get("kke_deskripsi"),
                                mahasiswa.get("kke_status"),
                                mahasiswa.get("kke_created_by"),
                                mahasiswa.get("kke_created_date"),
                                mahasiswa.get("kke_modif_by"),
                                mahasiswa.get("kke_modif_date"),
                                mahasiswa.get("pro_nama")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }
                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                // Handle failure
                data.setValue(null);
            }
        });

        return data;
    }

    //List Program Berdasarkan KK
    public MutableLiveData<List<ProgramModel>> findAllProgrambyKK(String kke_id) {
        MutableLiveData<List<ProgramModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.getAllProgramByKK(kke_id);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<ProgramModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        ProgramModel mahasiswaVO = new ProgramModel(
                                mahasiswa.get("pro_id"),
                                mahasiswa.get("pro_nama"),
                                mahasiswa.get("pro_deskripsi"),
                                mahasiswa.get("pro_status"),
                                mahasiswa.get("pro_created_by"),
                                mahasiswa.get("pro_created_date"),
                                mahasiswa.get("pro_modif_by"),
                                mahasiswa.get("pro_modif_date"),
                                mahasiswa.get("kke_id"),
                                mahasiswa.get("kke_nama")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }
                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    //List Kategori Berdasarkan Program
    public MutableLiveData<List<KategoriModel>> findAllKategoribyProgram(String pro_id) {
        MutableLiveData<List<KategoriModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.getAllKategoriByProgram(pro_id);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<KategoriModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        KategoriModel mahasiswaVO = new KategoriModel(
                                mahasiswa.get("kat_id"),
                                mahasiswa.get("kat_nama"),
                                mahasiswa.get("kat_deskripsi"),
                                mahasiswa.get("kat_status"),
                                mahasiswa.get("pro_id"),
                                mahasiswa.get("pro_nama"),
                                mahasiswa.get("jumlahMateri")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }

                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
    //List Materi Berdasarkan Kategori
    public MutableLiveData<List<MateriModel>> findAllMateriByKategori(String kat_id) {
        MutableLiveData<List<MateriModel>> data = new MutableLiveData<>();
        Call<Map<String, Object>> call = mMyService.getAllMateriByKategori(kat_id);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Map<String, Object> responseBody = response.body();
                    int code = ((Double) responseBody.get("code")).intValue();
                    String message = (String) responseBody.get("message");
                    List<Map<String, String>> dataList = (List<Map<String, String>>) responseBody.get("data");

                    List<MateriModel> mahasiswaList = new ArrayList<>();
                    for (Map<String, String> mahasiswa : dataList) {
                        MateriModel mahasiswaVO = new MateriModel(
                                mahasiswa.get("mat_id"),
                                mahasiswa.get("kat_id"),
                                mahasiswa.get("mat_judul"),
                                mahasiswa.get("mat_file_pdf"),
                                mahasiswa.get("mat_file_video"),
                                mahasiswa.get("mat_pengenalan"),
                                mahasiswa.get("mat_keterangan")
                        );
                        mahasiswaList.add(mahasiswaVO);
                    }

                    data.setValue(mahasiswaList);
                } else {
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}

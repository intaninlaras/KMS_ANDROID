package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProdiModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MyService {
    //List Prodi
    @POST("KKs/GetListProdi")
    Call<List<ProdiModel>> getDataProdi(@Header("Cookie") String token,
                                        @Header("Accept") String accept,
                                        @Body RequestBody body);
    //Riwayat Materi
    @POST("Materis/GetRiwayatMateri")
    Call<List<MateriModel>> getRiwayatMateri(@Header("Cookie") String token,
                                         @Header("Accept") String accept,
                                         @Body RequestBody body);
    //List KK Berdasarkan Prodi
    @POST("KKs/GetKKbyProdi")
    Call<List<KKModel>> getDataKKByProdi(@Header("Cookie") String token,
                                         @Header("Accept") String accept,
                                         @Body RequestBody body);
    // List Program Berdasarkan KK
    @POST("Program/GetProgramBykk")
    Call<List<ProgramModel>> getDataProgramByKK(@Header("Cookie") String token,
                                                @Header("Accept") String accept,
                                                @Body RequestBody body);
    //List Kategori Berdasarkan Program
    @POST("KategoriProgram/GetDataKategoriByProgram")
    Call<List<KategoriModel>> getDataKategoriByProgram(@Header("Cookie") String token,
                                                       @Header("Accept") String accept,
                                                       @Body RequestBody body);
    //List Materi Berdasarkan Ktegori
    @POST("Materis/GetMateriByKategori")
    Call<List<MateriModel>> getDataMateriByKategori(@Header("Cookie") String token,
                                                       @Header("Accept") String accept,
                                                       @Body RequestBody body);
}

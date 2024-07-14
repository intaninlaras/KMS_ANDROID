package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KKModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.KategoriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.MateriModel;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model.ProgramModel;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyService {
    //List Prodi
    @GET("prodi/getAllProdi")
    Call<Map<String, Object>> findallprodi();
    //Riwayat Materi
    @GET("materi/getAllRiwayatMateri")
    Call<Map<String, Object>> getAllRiwayatMateri(@Query("kry_id") String kry_id);
    // List KK Berdasarkan Prodi
    @GET("kk/getAllKKByProdi")
    Call<Map<String, Object>> getAllKKByProdi(@Query("pro_id") String kry_id);
    // List Program Berdasarkan KK
    @GET("program/getAllProgramByKK")
    Call<Map<String, Object>> getAllProgramByKK(@Query("kke_id") String kke_id);
    // List Kategori Berdasarkan Program
    @GET("kategori/getAllKategoriByProgram")
    Call<Map<String, Object>> getAllKategoriByProgram(@Query("pro_id") String pro_id);
    // List Materi Berdasarkan Kategori
    @GET("materi/getAllMateriByKategori")
    Call<Map<String, Object>> getAllMateriByKategori(@Query("kat_id") String kat_id);
}

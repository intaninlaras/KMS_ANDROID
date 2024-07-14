package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API;

import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.MyService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiUtils {

//    public static final String API_URL = "http://10.1.11.136:8080/";
public static final String API_URL = "http://192.168.0.217:8080/";
//public static final String API_URL = "http://10.10.5.33:8080/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static MyService getProdiService() {
        return getClient(API_URL).create(MyService.class);
    }
}

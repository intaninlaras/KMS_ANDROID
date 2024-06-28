package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.LoginService;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.PKService;
import com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.Service.ProdiService;

public class ApiUtils {

    public static final String API_URL = "";

    public ApiUtils() {
    }

    public static ProdiService getProdiService(){
        return RetrofitClient.getClient(API_URL).create(ProdiService.class);
    }

    public static PKService getPKService(){
        return RetrofitClient.getClient(API_URL).create(PKService.class);
    }
    public static LoginService getLoginService(){
        return RetrofitClient.getClient(API_URL).create(LoginService.class);
    }
}

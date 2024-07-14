package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdiModel {

    @SerializedName("pro_id")
    @Expose
    private String pro_id;

    @SerializedName("pro_nama")
    @Expose
    private String pro_nama;

    public ProdiModel() {
    }

    public ProdiModel(String pro_id, String pro_nama) {
        this.pro_id = pro_id;
        this.pro_nama = pro_nama;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nama() {
        return pro_nama;
    }

    public void setPro_nama(String pro_nama) {
        this.pro_nama = pro_nama;
    }
}

package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

public class ProdiModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    private List<PKModel> pkModelList;

    public ProdiModel() {
        this.id = UUID.randomUUID().toString();
        this.nama = "";
    }

    public ProdiModel(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public ProdiModel(String id, String nama, List<PKModel> pkModelList) {
        this.id = id;
        this.nama = nama;
        this.pkModelList = pkModelList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<PKModel> getPkModelList() {
        return pkModelList;
    }

    public void setPkModelList(List<PKModel> pkModelList) {
        this.pkModelList = pkModelList;
    }
}

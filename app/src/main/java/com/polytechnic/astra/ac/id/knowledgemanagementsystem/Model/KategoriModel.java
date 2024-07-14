package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KategoriModel {
    @SerializedName("kat_id")
    @Expose
    private String katId;
    @SerializedName("kat_nama")
    @Expose
    private String katNama;
    @SerializedName("kat_desktipsi")
    @Expose
    private String katDeskripsi;
    @SerializedName("kat_status")
    @Expose
    private String katStatus;
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("pro_nama")
    @Expose
    private String proNama;
    @SerializedName("jumlahMateri")
    @Expose
    private String jumlahMateri;

    // Constructors
    public KategoriModel() {
    }

    public KategoriModel(String katId, String katNama, String katDeskripsi, String katStatus, String proId, String proNama,String jumlahMateri) {
        this.katId = katId;
        this.katNama = katNama;
        this.katDeskripsi = katDeskripsi;
        this.katStatus = katStatus;
        this.proId = proId;
        this.proNama = proNama;
        this.jumlahMateri = jumlahMateri;
    }

    // Getters and Setters
    public String getKatId() {
        return katId;
    }

    public void setKatId(String katId) {
        this.katId = katId;
    }

    public String getKatNama() {
        return katNama;
    }

    public void setKatNama(String katNama) {
        this.katNama = katNama;
    }

    public String getKatDeskripsi() {
        return katDeskripsi;
    }

    public void setKatDeskripsi(String katDeskripsi) {
        this.katDeskripsi = katDeskripsi;
    }

    public String getKatStatus() {
        return katStatus;
    }

    public void setKatStatus(String katStatus) {
        this.katStatus = katStatus;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProNama() {
        return proNama;
    }

    public void setProNama(String proNama) {
        this.proNama = proNama;
    }

    public String getJumlahMateri() {
        return jumlahMateri;
    }

    public void setJumlahMateri(String jumlahMateri) {
        this.jumlahMateri = jumlahMateri;
    }
}

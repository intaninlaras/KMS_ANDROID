package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

public class KategoriModel {
    private String katId;
    private String katNama;
    private String katDeskripsi;
    private String katStatus;
    private String proId;
    private String proNama;

    // Constructors
    public KategoriModel() {
    }

    public KategoriModel(String katId, String katNama, String katDeskripsi, String katStatus, String proId, String proNama) {
        this.katId = katId;
        this.katNama = katNama;
        this.katDeskripsi = katDeskripsi;
        this.katStatus = katStatus;
        this.proId = proId;
        this.proNama = proNama;
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
}

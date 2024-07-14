package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProgramModel {
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("pro_nama")
    @Expose
    private String proNama;
    @SerializedName("pro_deskripsi")
    @Expose
    private String proDeskripsi;
    @SerializedName("pro_status")
    @Expose
    private String proStatus;
    @SerializedName("pro_created_by")
    @Expose
    private String proCreatedBy;
    @SerializedName("pro_created_date")
    @Expose
    private String proCreatedDate;
    @SerializedName("pro_modif_by")
    @Expose
    private String proModifBy;
    @SerializedName("pro_modif_date")
    @Expose
    private String proModifDate;
    @SerializedName("kke_id")
    @Expose
    private String kkeId;
    @SerializedName("kke_nama")
    @Expose
    private String kkeNama;

    public ProgramModel() {
    }

    public ProgramModel(String proId, String proNama, String proDeskripsi, String proStatus, String proCreatedBy, String proCreatedDate, String proModifBy, String proModifDate, String kkeId, String kkeNama) {
        this.proId = proId;
        this.proNama = proNama;
        this.proDeskripsi = proDeskripsi;
        this.proStatus = proStatus;
        this.proCreatedBy = proCreatedBy;
        this.proCreatedDate = proCreatedDate;
        this.proModifBy = proModifBy;
        this.proModifDate = proModifDate;
        this.kkeId = kkeId;
        this.kkeNama = kkeNama;
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

    public String getProDeskripsi() {
        return proDeskripsi;
    }

    public void setProDeskripsi(String proDeskripsi) {
        this.proDeskripsi = proDeskripsi;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProCreatedBy() {
        return proCreatedBy;
    }

    public void setProCreatedBy(String proCreatedBy) {
        this.proCreatedBy = proCreatedBy;
    }

    public String getProCreatedDate() {
        return proCreatedDate;
    }

    public void setProCreatedDate(String proCreatedDate) {
        this.proCreatedDate = proCreatedDate;
    }

    public String getProModifBy() {
        return proModifBy;
    }

    public void setProModifBy(String proModifBy) {
        this.proModifBy = proModifBy;
    }

    public String getProModifDate() {
        return proModifDate;
    }

    public void setProModifDate(String proModifDate) {
        this.proModifDate = proModifDate;
    }

    public String getKkeId() {
        return kkeId;
    }

    public void setKkeId(String kkeId) {
        this.kkeId = kkeId;
    }

    public String getKkeNama() {
        return kkeNama;
    }

    public void setKkeNama(String kkeNama) {
        this.kkeNama = kkeNama;
    }
}
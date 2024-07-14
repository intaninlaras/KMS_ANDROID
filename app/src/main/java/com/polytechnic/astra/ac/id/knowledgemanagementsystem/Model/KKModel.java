package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KKModel {
    @SerializedName("kke_id")
    @Expose
    private String kkeId;
    @SerializedName("kke_nama")
    @Expose
    private String kkeNama;
    @SerializedName("pro_id")
    @Expose
    private String proId;
    @SerializedName("kry_id")
    @Expose
    private String kryId;
    @SerializedName("kke_deskripsi")
    @Expose
    private String kkeDeskripsi;
    @SerializedName("kke_status")
    @Expose
    private String kkeStatus;
    @SerializedName("kke_created_by")
    @Expose
    private String kkeCreatedBy;
    @SerializedName("kke_created_date")
    @Expose
    private String kkeCreatedDate;
    @SerializedName("kke_modif_by")
    @Expose
    private String kkeModifBy;
    @SerializedName("kke_modif_date")
    @Expose
    private String kkeModifDate;
    @SerializedName("pro_nama")
    @Expose
    private String proNama;

    // Constructors
    public KKModel() {
    }

    public KKModel(String kkeId, String kkeNama, String proId, String kryId, String kkeDeskripsi,
                   String kkeStatus, String kkeCreatedBy, String kkeCreatedDate,
                   String kkeModifBy, String kkeModifDate, String proNama) {
        this.kkeId = kkeId;
        this.kkeNama = kkeNama;
        this.proId = proId;
        this.kryId = kryId;
        this.kkeDeskripsi = kkeDeskripsi;
        this.kkeStatus = kkeStatus;
        this.kkeCreatedBy = kkeCreatedBy;
        this.kkeCreatedDate = kkeCreatedDate;
        this.kkeModifBy = kkeModifBy;
        this.kkeModifDate = kkeModifDate;
        this.proNama = proNama;
    }

    // Getters and Setters
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

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getKryId() {
        return kryId;
    }

    public void setKryId(String kryId) {
        this.kryId = kryId;
    }

    public String getKkeDeskripsi() {
        return kkeDeskripsi;
    }

    public void setKkeDeskripsi(String kkeDeskripsi) {
        this.kkeDeskripsi = kkeDeskripsi;
    }

    public String getKkeStatus() {
        return kkeStatus;
    }

    public void setKkeStatus(String kkeStatus) {
        this.kkeStatus = kkeStatus;
    }

    public String getKkeCreatedBy() {
        return kkeCreatedBy;
    }

    public void setKkeCreatedBy(String kkeCreatedBy) {
        this.kkeCreatedBy = kkeCreatedBy;
    }

    public String getKkeCreatedDate() {
        return kkeCreatedDate;
    }

    public void setKkeCreatedDate(String kkeCreatedDate) {
        this.kkeCreatedDate = kkeCreatedDate;
    }

    public String getKkeModifBy() {
        return kkeModifBy;
    }

    public void setKkeModifBy(String kkeModifBy) {
        this.kkeModifBy = kkeModifBy;
    }

    public String getKkeModifDate() {
        return kkeModifDate;
    }

    public void setKkeModifDate(String kkeModifDate) {
        this.kkeModifDate = kkeModifDate;
    }

    public String getProNama() {
        return proNama;
    }

    public void setProNama(String proNama) {
        this.proNama = proNama;
    }
}

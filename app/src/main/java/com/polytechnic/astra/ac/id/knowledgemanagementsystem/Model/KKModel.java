package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

public class KKModel {
    private String kkeId;
    private String kkeNama;
    private String proId;
    private String kryId;
    private String kkeDeskripsi;
    private String kkeStatus;
    private String kkeCreatedBy;
    private String kkeCreatedDate;
    private String kkeModifBy;
    private String kkeModifDate;
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

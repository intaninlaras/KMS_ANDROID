package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MateriModel {
    @SerializedName("matId")
    @Expose
    private String matId;

    @SerializedName("matJudul")
    @Expose
    private String matJudul;
    @SerializedName("katId")
    @Expose
    private String katId;

    @SerializedName("katNama")
    @Expose
    private String katNama;

    @SerializedName("matFilePdf")
    @Expose
    private String matFilePdf;

    @SerializedName("matFileVideo")
    @Expose
    private String matFileVideo;

    @SerializedName("matPengenalan")
    @Expose
    private String matPengenalan;

    @SerializedName("matKeterangan")
    @Expose
    private String matKeterangan;

    @SerializedName("matKunci")
    @Expose
    private String matKunci;

    @SerializedName("matGambar")
    @Expose
    private String matGambar;

    @SerializedName("matSharPdf")
    @Expose
    private String matSharPdf;

    @SerializedName("matSharVideo")
    @Expose
    private String matSharVideo;

    @SerializedName("matStatus")
    @Expose
    private String matStatus;

    public MateriModel() {
    }

    public MateriModel(String matId, String matJudul, String matFilePdf, String matFileVideo, String matPengenalan, String matKeterangan, String matKunci, String matGambar, String matSharPdf, String matSharVideo, String matStatus) {
        this.matId = matId;
        this.matJudul = matJudul;
        this.matFilePdf = matFilePdf;
        this.matFileVideo = matFileVideo;
        this.matPengenalan = matPengenalan;
        this.matKeterangan = matKeterangan;
        this.matKunci = matKunci;
        this.matGambar = matGambar;
        this.matSharPdf = matSharPdf;
        this.matSharVideo = matSharVideo;
        this.matStatus = matStatus;
    }

    public String getMatId() {
        return matId;
    }

    public void setMatId(String matId) {
        this.matId = matId;
    }

    public String getMatJudul() {
        return matJudul;
    }

    public void setMatJudul(String matJudul) {
        this.matJudul = matJudul;
    }

    public String getMatFilePdf() {
        return matFilePdf;
    }

    public void setMatFilePdf(String matFilePdf) {
        this.matFilePdf = matFilePdf;
    }

    public String getMatFileVideo() {
        return matFileVideo;
    }

    public void setMatFileVideo(String matFileVideo) {
        this.matFileVideo = matFileVideo;
    }

    public String getMatPengenalan() {
        return matPengenalan;
    }

    public void setMatPengenalan(String matPengenalan) {
        this.matPengenalan = matPengenalan;
    }

    public String getMatKeterangan() {
        return matKeterangan;
    }

    public void setMatKeterangan(String matKeterangan) {
        this.matKeterangan = matKeterangan;
    }

    public String getMatKunci() {
        return matKunci;
    }

    public void setMatKunci(String matKunci) {
        this.matKunci = matKunci;
    }

    public String getMatGambar() {
        return matGambar;
    }

    public void setMatGambar(String matGambar) {
        this.matGambar = matGambar;
    }

    public String getMatSharPdf() {
        return matSharPdf;
    }

    public void setMatSharPdf(String matSharPdf) {
        this.matSharPdf = matSharPdf;
    }

    public String getMatSharVideo() {
        return matSharVideo;
    }

    public void setMatSharVideo(String matSharVideo) {
        this.matSharVideo = matSharVideo;
    }

    public String getMatStatus() {
        return matStatus;
    }

    public void setMatStatus(String matStatus) {
        this.matStatus = matStatus;
    }
}

package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MateriModel {
    @SerializedName("mat_id")
    @Expose
    private String matId;

    @SerializedName("kat_id")
    @Expose
    private String katId;

    @SerializedName("mat_judul")
    @Expose
    private String matJudul;

    @SerializedName("mat_file_pdf")
    @Expose
    private String matFilePdf;

    @SerializedName("mat_file_video")
    @Expose
    private String matFileVideo;

    @SerializedName("mat_pengenalan")
    @Expose
    private String matPengenalan;

    @SerializedName("mat_keterangan")
    @Expose
    private String matKeterangan;



    public MateriModel() {
    }

    public MateriModel(String matId, String katId, String matJudul, String matFilePdf, String matFileVideo, String matPengenalan, String matKeterangan) {
        this.matId = matId;
        this.katId = katId;
        this.matJudul = matJudul;
        this.matFilePdf = matFilePdf;
        this.matFileVideo = matFileVideo;
        this.matPengenalan = matPengenalan;
        this.matKeterangan = matKeterangan;
    }

    public String getKatId() {
        return katId;
    }

    public void setKatId(String katId) {
        this.katId = katId;
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
}

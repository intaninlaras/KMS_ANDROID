package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MateriVO {
    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("kategori")
    @Expose
    private String kategori;

    @SerializedName("judul")
    @Expose
    private String judul;

    @SerializedName("file_pdf")
    @Expose
    private String filePdf;

    @SerializedName("file_vidio")
    @Expose
    private String fileVidio;

    @SerializedName("pengenalan")
    @Expose
    private String pengenalan;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    @SerializedName("kataKunci")
    @Expose
    private String kataKunci;

    @SerializedName("uploader")
    @Expose
    private String uploader;

    @SerializedName("creadate")
    @Expose
    private String creadate;

    @SerializedName("gambar")
    @Expose
    private String gambar;

    @SerializedName("status")
    @Expose
    private String status;

    public MateriVO() {
    }

    public MateriVO(String key, String kategori, String judul, String filePdf, String fileVidio, String pengenalan, String keterangan, String kataKunci, String uploader, String creadate, String gambar, String status) {
        this.key = key;
        this.kategori = kategori;
        this.judul = judul;
        this.filePdf = filePdf;
        this.fileVidio = fileVidio;
        this.pengenalan = pengenalan;
        this.keterangan = keterangan;
        this.kataKunci = kataKunci;
        this.uploader = uploader;
        this.creadate = creadate;
        this.gambar = gambar;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getFilePdf() {
        return filePdf;
    }

    public void setFilePdf(String filePdf) {
        this.filePdf = filePdf;
    }

    public String getFileVidio() {
        return fileVidio;
    }

    public void setFileVidio(String fileVidio) {
        this.fileVidio = fileVidio;
    }

    public String getPengenalan() {
        return pengenalan;
    }

    public void setPengenalan(String pengenalan) {
        this.pengenalan = pengenalan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKataKunci() {
        return kataKunci;
    }

    public void setKataKunci(String kataKunci) {
        this.kataKunci = kataKunci;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getCreadate() {
        return creadate;
    }

    public void setCreadate(String creadate) {
        this.creadate = creadate;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

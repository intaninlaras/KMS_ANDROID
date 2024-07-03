package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

public class MateriViewVO {
    private String key;
    private String kategori;
    private String judul;
    private String file_pdf;
    private String file_vidio;
    private String pengenalan;
    private String keterangan;
    private String kataKunci;
    private String uploader;
    private String creadate;
    private String gambar;
    private String status;

    public MateriViewVO() {
    }

    public MateriViewVO(String key, String kategori, String judul, String file_pdf, String file_vidio, String pengenalan, String keterangan, String kataKunci, String uploader, String creadate, String gambar, String status) {
        this.key = key;
        this.kategori = kategori;
        this.judul = judul;
        this.file_pdf = file_pdf;
        this.file_vidio = file_vidio;
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

    public String getFile_pdf() {
        return file_pdf;
    }

    public void setFile_pdf(String file_pdf) {
        this.file_pdf = file_pdf;
    }

    public String getFile_vidio() {
        return file_vidio;
    }

    public void setFile_vidio(String file_vidio) {
        this.file_vidio = file_vidio;
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

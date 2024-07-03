package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

public class KategoriViewVO {
    private String id;
    private String namaKategori;
    private String detailKategori;

    public KategoriViewVO(String id, String namaKategori, String detailKategori) {
        this.id = id;
        this.namaKategori = namaKategori;
        this.detailKategori = detailKategori;
    }

    public String getId() {
        return id;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public String getDetailKategori() {
        return detailKategori;
    }
}

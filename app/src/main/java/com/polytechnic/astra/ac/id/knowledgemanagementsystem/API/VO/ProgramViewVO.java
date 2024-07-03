package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

public class ProgramViewVO {
    private String id;
    private String namaProgram;
    private String detailProgram;

    public ProgramViewVO(String id, String namaProgram, String detailProgram) {
        this.id = id;
        this.namaProgram = namaProgram;
        this.detailProgram = detailProgram;
    }

    public String getId() {
        return id;
    }

    public String getNamaProgram() {
        return namaProgram;
    }

    public String getDetailProgram() {
        return detailProgram;
    }
}

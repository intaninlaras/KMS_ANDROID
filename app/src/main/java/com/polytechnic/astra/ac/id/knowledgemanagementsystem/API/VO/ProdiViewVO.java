package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

public class ProdiViewVO {

    private String id;
    private String name;

    public ProdiViewVO() {
    }

    public ProdiViewVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

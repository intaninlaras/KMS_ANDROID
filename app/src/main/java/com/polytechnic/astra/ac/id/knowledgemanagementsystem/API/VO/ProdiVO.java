package com.polytechnic.astra.ac.id.knowledgemanagementsystem.API.VO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProdiVO {

    @SerializedName("Value")
    @Expose
    private String Value;

    @SerializedName("Text")
    @Expose
    private String Text;

    public ProdiVO() {
    }

    public ProdiVO(String Value, String Text) {
        this.Value = Value;
        this.Text = Text;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}

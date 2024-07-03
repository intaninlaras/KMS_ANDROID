package com.polytechnic.astra.ac.id.knowledgemanagementsystem.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProdiModel {

    @SerializedName("Value")
    @Expose
    private String Value;

    @SerializedName("Text")
    @Expose
    private String Text;

    public ProdiModel() {
    }

    public ProdiModel(String Value, String Text) {
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

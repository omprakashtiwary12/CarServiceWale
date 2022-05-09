package com.commdel.carservicewale.networking;

import com.google.gson.annotations.Expose;

public class Config {

    @Expose
    private String key;
    @Expose
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

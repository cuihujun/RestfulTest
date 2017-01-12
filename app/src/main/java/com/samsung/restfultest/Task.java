package com.samsung.restfultest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("text")
    @Expose
    private String text;

    public Task(long id, String text) {
        this.id = id;
        this.text = text;
    }
}

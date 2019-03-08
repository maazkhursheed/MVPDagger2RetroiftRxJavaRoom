package com.litgmet.testapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class PostsData {

    @PrimaryKey(autoGenerate = true)
    private int slNo;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("userId")
    @Expose
    private String userId;

    public PostsData() {
    }

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }


    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getBody () {
        return body;
    }

    public void setBody (String body) {
        this.body = body;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

}

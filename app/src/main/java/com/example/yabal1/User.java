package com.example.yabal1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("user_name")
    private String user_name;

    @Expose
    @SerializedName("phone")
    private String phone;

    public User(String user_name, String phone) {
        this.user_name = user_name;
        this.phone = phone;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


package com.example.emj.diabetesapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by EMJ on 2018-10-20.
 */

public class Alert {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("sendAlert")
    @Expose
    private boolean sendAlert;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSendAlert() {
        return sendAlert;
    }

    public void setSendAlert(boolean sendAlert) {
        this.sendAlert = sendAlert;
    }
}

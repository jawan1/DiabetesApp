package com.example.emj.diabetesapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by EMJ on 2018-10-11.
 */

public class User {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("minGlucose")
    @Expose
    private int minGlucose;
    @SerializedName("maxGlucose")
    @Expose
    private int maxGlucose;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMinGlucose() {
        return minGlucose;
    }

    public void setMinGlucose(int minGlucose) {
        this.minGlucose = minGlucose;
    }

    public int getMaxGlucose() {
        return maxGlucose;
    }

    public void setMaxGlucose(int maxGlucose) {
        this.maxGlucose = maxGlucose;
    }
}

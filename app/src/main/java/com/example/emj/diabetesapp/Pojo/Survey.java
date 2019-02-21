package com.example.emj.diabetesapp.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EMJ on 2018-10-11.
 */

public class Survey {

    @SerializedName("dateSurvey")
    @Expose
    private String dateSurvey;
    @SerializedName("value")
    @Expose
    private int survey;
    @SerializedName("inRange")
    @Expose
    private boolean inRange;

    public Survey(){}

    public Survey(String dateSurvey, int survey) {
        this.dateSurvey = dateSurvey;
        this.survey = survey;
    }

    public String getDateSurvey() {
        return dateSurvey;
    }

    public void setDateSurvey(String dateSurvey) {
        this.dateSurvey = dateSurvey;
    }

    public int getSurvey() {
        return survey;
    }

    public void setSurvey(int survey) {
        this.survey = survey;
    }

    public boolean isInRange() {
        return inRange;
    }

    public void setInRange(boolean inRange) {
        this.inRange = inRange;
    }
}

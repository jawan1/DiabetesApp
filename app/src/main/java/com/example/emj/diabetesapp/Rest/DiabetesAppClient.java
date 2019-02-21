package com.example.emj.diabetesapp.Rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by EMJ on 2018-10-11.
 */

public class DiabetesAppClient {

    private Retrofit retrofit;
    private DiabetesAppApi diabetesAppApi;

    public DiabetesAppClient() {
        retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.59:8080/diabetesapp/").addConverterFactory(GsonConverterFactory.create()).build();
        diabetesAppApi = retrofit.create(DiabetesAppApi.class);
    }

    public DiabetesAppApi getDiabetesAppApi() {
        return diabetesAppApi;
    }

}

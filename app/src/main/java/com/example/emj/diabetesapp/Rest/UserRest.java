package com.example.emj.diabetesapp.Rest;

import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.Alert;
import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.Pojo.User;
import com.example.emj.diabetesapp.SharedPreferences.Session;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.emj.diabetesapp.SmsHelper.Sms;

/**
 * Created by EMJ on 2018-10-11.
 */

public class UserRest {

    private DiabetesAppApi diabetesAppApi;
    private Activity activity;
    private Session session;

    public UserRest(Activity activity) {
        diabetesAppApi = new DiabetesAppClient().getDiabetesAppApi();
        this.activity = activity;
        session = new Session(activity);
    }

    public void addSurvey(final Survey survey) {
        Call<Alert> addSurvey = diabetesAppApi.addSurvey("Bearer " + session.getJwt(), survey);
        addSurvey.enqueue(new Callback<Alert>() {
            @Override
            public void onResponse(Call<Alert> call, Response<Alert> response) {
                //Toast.makeText(context, "onResponse: " + response.code(), Toast.LENGTH_SHORT).show();
                if (response.code() == 200){
                    Alert alert = response.body();
                    if(alert.isSendAlert()){
                        String smsContent = "Uwaga! Moj cukier jest poza zakresem: " + survey.getSurvey();
                        new Sms(activity).sendSms(alert.getPhone(), smsContent);
                    }
                }
            }

            @Override
            public void onFailure(Call<Alert> call, Throwable t) {
                Toast.makeText(activity, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<Survey> getSurveys(String startDate, String endDate) {
        List<Survey> newList = new ArrayList<>();
        try {
            Response<List<Survey>> response = diabetesAppApi.getSurveys("Bearer " + session.getJwt(), startDate, endDate).execute();
            if (response.code() == 200) {
                newList = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList;
    }

    public User getUser() {
        User user = new User();
        try {
            Response<User> response = diabetesAppApi.getUser("Bearer " + session.getJwt()).execute();
            if (response.code() == 200) {
                user = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        Call<ResponseBody> updateUser = diabetesAppApi.updateUser("Bearer " + session.getJwt(), user);
        updateUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200){
                    Toast.makeText(activity, "Profil zostal zaaktualizowany", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(activity, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

//        try {
//                Response<ResponseBody> response = diabetesAppApi.addSurvey("Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwibG9naW4iOiJqYXdAY29tIn0.HDTyY3q63lWdDNJ3thgXw3WAXA4ztDgnIdj2Trqx32I", survey).execute();
//        Log.d("Status", ""+response.code());
//        } catch (IOException e) {
//        Log.d("Exception", ""+e.getMessage());
//        }
package com.example.emj.diabetesapp.Rest;

import com.example.emj.diabetesapp.Pojo.Alert;
import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.Pojo.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by EMJ on 2018-10-11.
 */

public interface DiabetesAppApi {

    @POST("registration")
    Call<ResponseBody> registerUser(@Body User user);

    @POST("logging")
    @FormUrlEncoded
    Call<ResponseBody> logInUser(@Field("login") String login, @Field("password") String password);

    @GET("user")
    Call<User> getUser(@Header("Authorization") String authorization);

    @PUT("user")
    Call<ResponseBody> updateUser(@Header("Authorization") String authorization, @Body User user);

    @POST("user/new/survey")
    Call<Alert> addSurvey(@Header("Authorization") String authorization, @Body Survey survey);

    @POST("user/surveys")
    @FormUrlEncoded
    Call<List<Survey>> getSurveys(@Header("Authorization") String authorization, @Field("startDate") String startDate, @Field("endDate") String endDate);

}

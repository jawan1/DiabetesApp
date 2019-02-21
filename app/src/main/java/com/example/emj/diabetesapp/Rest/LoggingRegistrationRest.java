package com.example.emj.diabetesapp.Rest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.User;
import com.example.emj.diabetesapp.SharedPreferences.Session;
import com.example.emj.diabetesapp.View.LoginActivity;
import com.example.emj.diabetesapp.View.MainActivity;
import com.example.emj.diabetesapp.View.ProfileActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by EMJ on 2018-10-11.
 */

public class LoggingRegistrationRest {

    private DiabetesAppApi diabetesAppApi;
    private Activity activity;

    public LoggingRegistrationRest(Activity activity) {
        diabetesAppApi = new DiabetesAppClient().getDiabetesAppApi();
        this.activity = activity;
    }

    public void registerUser(User user) {
        Call<ResponseBody> registerUser = diabetesAppApi.registerUser(user);
        registerUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        boolean state = jsonObject.getBoolean("state");

                        if (state){
                            Toast.makeText(activity, "Dodano uzytkownika", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(activity, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();

                        }
                        else {
                            Toast.makeText(activity, "Uzytkownik o takim loginie istnieje", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    Toast.makeText(activity, "onResponseElse: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(activity, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void logInUser(String login, String password) {
        Call<ResponseBody> logInUser = diabetesAppApi.logInUser(login, password);
        logInUser.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code() == 200) {
                    String keyJwt = response.headers().get("Authorization");
                    keyJwt = keyJwt.substring("Bearer".length()).trim();
                    new Session(activity).saveSession(keyJwt);
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                    activity.finish();
                }
                else if(response.code() == 401) {
                    Toast.makeText(activity, "Niepoprawne dane", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(activity, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

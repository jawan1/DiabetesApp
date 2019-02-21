package com.example.emj.diabetesapp.SharedPreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.emj.diabetesapp.View.LoginActivity;

/**
 * Created by EMJ on 2018-10-12.
 */

public class Session {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Session(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("DiabetesAppPreferences", 0);
        editor = sharedPreferences.edit();
    }

    public void saveSession(String keyJwt) {
        editor.putString("keyJwt", keyJwt);
        editor.commit();
    }

    public String getJwt() {
        return sharedPreferences.getString("keyJwt", null);
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public boolean checkSession() {
        if (sharedPreferences.getString("keyJwt", null) == (null)) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        }
        return false;
    }

}

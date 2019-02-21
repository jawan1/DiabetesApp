package com.example.emj.diabetesapp.SmsHelper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;

import com.example.emj.diabetesapp.View.MainActivity;

/**
 * Created by EMJ on 2018-10-20.
 */

public class Sms {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private Activity activity;

    public Sms(Activity activity){
        this.activity = activity;
    }

    public void sendSms(String phone, String smsContent){
        if (Build.VERSION.SDK_INT >= 23) {
            if (!checkPermission()) {
                requestPermission();
            }
            if(checkPermission()){
                SmsManager.getDefault().sendTextMessage(phone, null, smsContent, null, null);
            }
        }
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.SEND_SMS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);
    }

}

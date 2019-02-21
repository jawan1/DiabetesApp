package com.example.emj.diabetesapp.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.User;
import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Rest.LoggingRegistrationRest;
import com.example.emj.diabetesapp.Rest.UserRest;
import com.example.emj.diabetesapp.Threads.ProfileThread;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        new ProfileThread(this).execute();

        ((Button)findViewById(R.id.bSave)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ((EditText)findViewById(R.id.eName)).getText().toString();
                String surname = ((EditText)findViewById(R.id.eSurname)).getText().toString();
                String login = ((TextView)findViewById(R.id.eLogin)).getText().toString();
                String password = ((EditText)findViewById(R.id.ePassword)).getText().toString();
                String phone = ((EditText)findViewById(R.id.ePhone)).getText().toString();
                String minGlucose = ((EditText)findViewById(R.id.eMinGlucose)).getText().toString();
                String maxGlucose = ((EditText)findViewById(R.id.eMaxGlucose)).getText().toString();

                if(name.trim().equals("") || surname.trim().equals("") || login.trim().equals("") || password.trim().equals("")
                        || phone.trim().equals("") || minGlucose.trim().equals("") || maxGlucose.trim().equals("")) {
                    Toast.makeText(ProfileActivity.this, "Niepoprawny format danych", Toast.LENGTH_SHORT).show();
                }
                else {
                    try{
                        User user = new User();
                        user.setName(name);
                        user.setSurname(surname);
                        user.setLogin(login);
                        user.setPassword(password);
                        user.setPhone(phone);
                        user.setMinGlucose(Integer.parseInt(minGlucose));
                        user.setMaxGlucose(Integer.parseInt(maxGlucose));
                        //new LoggingRegistrationRest(RegisterActivity.this).registerUser(user);
                        new UserRest(ProfileActivity.this).updateUser(user);

                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                    catch (NumberFormatException exc) {
                        Toast.makeText(ProfileActivity.this, "Niepoprawny format poziomu glukozy", Toast.LENGTH_SHORT).show();
                    }
                }

                //new UserRest(ProfileActivity.this).updateUser(user);


            }
        });
    }
}

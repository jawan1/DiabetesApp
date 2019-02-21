package com.example.emj.diabetesapp.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.User;
import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Rest.LoggingRegistrationRest;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ((Button)findViewById(R.id.bRegister)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText)findViewById(R.id.eName)).getText().toString();
                String surname = ((EditText)findViewById(R.id.eSurname)).getText().toString();
                String login = ((EditText)findViewById(R.id.eLogin)).getText().toString();
                String password = ((EditText)findViewById(R.id.ePassword)).getText().toString();
                String phone = ((EditText)findViewById(R.id.ePhone)).getText().toString();
                String minGlucose = ((EditText)findViewById(R.id.eMinGlucose)).getText().toString();
                String maxGlucose = ((EditText)findViewById(R.id.eMaxGlucose)).getText().toString();

                if(name.trim().equals("") || surname.trim().equals("") || login.trim().equals("") || password.trim().equals("")
                        || phone.trim().equals("") || minGlucose.trim().equals("") || maxGlucose.trim().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Niepoprawny format danych", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        User user = new User();
                        user.setName(name);
                        user.setSurname(surname);
                        user.setLogin(login);
                        user.setPassword(password);
                        user.setPhone(phone);
                        user.setMinGlucose(Integer.parseInt(minGlucose));
                        user.setMaxGlucose(Integer.parseInt(maxGlucose));
                        new LoggingRegistrationRest(RegisterActivity.this).registerUser(user);
                    } catch (NumberFormatException exc) {
                        Toast.makeText(RegisterActivity.this, "Niepoprawny format poziomu glukozy", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}

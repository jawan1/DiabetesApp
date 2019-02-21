package com.example.emj.diabetesapp.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Rest.LoggingRegistrationRest;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((Button)findViewById(R.id.bLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = ((EditText)findViewById(R.id.eLogin)).getText().toString();
                String password = ((EditText)findViewById(R.id.ePassword)).getText().toString();

                new LoggingRegistrationRest(LoginActivity.this).logInUser(login, password);
            }
        });
        ((Button)findViewById(R.id.bRegister)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}

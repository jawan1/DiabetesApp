package com.example.emj.diabetesapp.View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Pojo.MenuRow;
import com.example.emj.diabetesapp.Adapters.MultiMenuAdapter;
import com.example.emj.diabetesapp.Rest.UserRest;
import com.example.emj.diabetesapp.SharedPreferences.Session;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends Activity {

    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        if(session.checkSession()) finish();

        MultiMenuAdapter multiMenuAdapter = new MultiMenuAdapter(this, R.layout.menu_multi_list, MenuRow.menuRows);
        ListView listView = (ListView) findViewById(R.id.menuList);
        listView.setAdapter(multiMenuAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        createDialog();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, AllSurveysActivity.class));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "" + i, Toast.LENGTH_SHORT).show();
                        session.logout();
                        finish();
                        break;
                }
            }
        });
    }

    private void createDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_add_survey);

        dialog.findViewById(R.id.bNewSurvey).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    int survey = Integer.parseInt(((EditText)dialog.findViewById(R.id.newSurvey)).getText().toString());

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    simpleDateFormat.setTimeZone(calendar.getTimeZone());

                    UserRest userRest = new UserRest(MainActivity.this);
                    userRest.addSurvey(new Survey(simpleDateFormat.format(calendar.getTime()), survey));

                    dialog.cancel();
                } catch(NumberFormatException exc) {
                    Toast.makeText(MainActivity.this, "Podaj poprawny pomiar", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }


}

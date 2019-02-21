package com.example.emj.diabetesapp.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Adapters.AllSurveysAdapter;
import com.example.emj.diabetesapp.Threads.AllSurveysThread;

public class AllSurveysActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_surveys);

        Button okButton = (Button)findViewById(R.id.bOk);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startDate = ((EditText)findViewById(R.id.startDate)).getText().toString();
                String endDate = ((EditText)findViewById(R.id.endDate)).getText().toString();
                if (checkPattern(startDate) && checkPattern(endDate)) {
                    new AllSurveysThread(AllSurveysActivity.this).execute(startDate, endDate);
                }
                else {
                    Toast.makeText(AllSurveysActivity.this, "Zly format danych", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean checkPattern(String checkingDate) {
        return checkingDate.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }
}

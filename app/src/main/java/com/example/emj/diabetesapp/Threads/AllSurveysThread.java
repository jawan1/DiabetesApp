package com.example.emj.diabetesapp.Threads;

import android.os.AsyncTask;
import android.widget.ListView;

import com.example.emj.diabetesapp.Adapters.AllSurveysAdapter;
import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.R;
import com.example.emj.diabetesapp.Rest.UserRest;
import com.example.emj.diabetesapp.View.AllSurveysActivity;

import java.util.List;

/**
 * Created by EMJ on 2018-10-12.
 */

public class AllSurveysThread extends AsyncTask<String, Void, List<Survey>> {

    private AllSurveysActivity allSurveysActivity;

    public AllSurveysThread(AllSurveysActivity allSurveysActivity) {
        this.allSurveysActivity = allSurveysActivity;
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected List<Survey> doInBackground(String... dates) {
        return new UserRest(allSurveysActivity).getSurveys(dates[0], dates[1]);
    }

    @Override
    protected void onPostExecute(List<Survey> surveys) {
        AllSurveysAdapter allSurveysAdapter = new AllSurveysAdapter(allSurveysActivity, R.layout.list_of_surveys, surveys);
        ((ListView)allSurveysActivity.findViewById(R.id.list)).setAdapter(allSurveysAdapter);
    }
}

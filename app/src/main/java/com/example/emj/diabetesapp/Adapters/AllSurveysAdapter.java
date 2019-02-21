package com.example.emj.diabetesapp.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.emj.diabetesapp.Pojo.Survey;
import com.example.emj.diabetesapp.R;

import java.util.List;

/**
 * Created by EMJ on 2018-10-11.
 */

public class AllSurveysAdapter extends ArrayAdapter<Survey> {

    private Context context;
    private int resource;

    public AllSurveysAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Survey> surveys) {
        super(context, resource, surveys);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int id = position+1;
        String date = getItem(position).getDateSurvey();
        int survey = getItem(position).getSurvey();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        if(!getItem(position).isInRange()){
            convertView.setBackgroundColor(context.getResources().getColor(R.color.lightRed));
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.idSurvey);
        TextView textView2 = (TextView) convertView.findViewById(R.id.dateSurvey);
        TextView textView3 = (TextView) convertView.findViewById(R.id.survey);

        textView1.setText("" + id);
        textView2.setText(date);
        textView3.setText("" + survey);

        return convertView;

    }
}

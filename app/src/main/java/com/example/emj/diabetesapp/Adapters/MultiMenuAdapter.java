package com.example.emj.diabetesapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emj.diabetesapp.Pojo.MenuRow;
import com.example.emj.diabetesapp.R;

/**
 * Created by EMJ on 2018-07-29.
 */

public class MultiMenuAdapter extends ArrayAdapter<MenuRow> {

    private Context context;
    private int resource;

    public MultiMenuAdapter(Context context, int resource, MenuRow[] menuRow) {
        super(context, resource, menuRow);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String title = getItem(position).getTitle();
        int idPhoto = getItem(position).getIdPhoto();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
        TextView textView = (TextView) convertView.findViewById(R.id.title);

        imageView.setImageResource(idPhoto);
        textView.setText(title);

        return convertView;
    }
}

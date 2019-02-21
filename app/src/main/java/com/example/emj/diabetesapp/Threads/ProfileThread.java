package com.example.emj.diabetesapp.Threads;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import com.example.emj.diabetesapp.Pojo.User;
import com.example.emj.diabetesapp.Rest.UserRest;
import com.example.emj.diabetesapp.View.ProfileActivity;
import com.example.emj.diabetesapp.R;

/**
 * Created by EMJ on 2018-10-12.
 */

public class ProfileThread extends AsyncTask<Void, Void, User> {

    private ProfileActivity profileActivity;

    public ProfileThread(ProfileActivity profileActivity){
        this.profileActivity = profileActivity;
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected User doInBackground(Void... voids) {
        return new UserRest(profileActivity).getUser();
    }

    @Override
    protected void onPostExecute(User user) {
        ((EditText)profileActivity.findViewById(R.id.eName)).setText(user.getName());
        ((EditText)profileActivity.findViewById(R.id.eSurname)).setText(user.getSurname());
        ((TextView)profileActivity.findViewById(R.id.eLogin)).setText(user.getLogin());
        ((EditText)profileActivity.findViewById(R.id.ePassword)).setText(user.getPassword());
        ((EditText)profileActivity.findViewById(R.id.ePhone)).setText(user.getPhone());
        ((EditText)profileActivity.findViewById(R.id.eMinGlucose)).setText(""+user.getMinGlucose());
        ((EditText)profileActivity.findViewById(R.id.eMaxGlucose)).setText(""+user.getMaxGlucose());
    }
}

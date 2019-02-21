package com.example.emj.diabetesapp.Pojo;

import com.example.emj.diabetesapp.R;
/**
 * Created by EMJ on 2018-07-29.
 */

public class MenuRow {

    private int idPhoto;
    private String title;

    public static MenuRow[] menuRows = {
            new MenuRow(R.drawable.add, "Dodaj pomiar"),
            new MenuRow(R.drawable.list, "Wszystkie pomiary"),
            new MenuRow(R.drawable.man, "Profil"),
            new MenuRow(R.drawable.logout, "Wyloguj")
    };

    public MenuRow(int idPhoto, String title) {
        this.idPhoto = idPhoto;
        this.title = title;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

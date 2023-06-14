package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Objects;

public class accueil_bar extends AppCompatActivity {
    private Button btnbar;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_bar);

        Objects.requireNonNull(getSupportActionBar()).setTitle("accueil_bar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView img1 = findViewById(R.id.img1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bar);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        img1.setImageDrawable(roundedBitmapDrawable);

        ImageView img2 = findViewById(R.id.img2);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.barr);
        RoundedBitmapDrawable roundedBitmapDrawable1 = RoundedBitmapDrawableFactory.create(getResources(), bitmap1);
        roundedBitmapDrawable.setCircular(true);
        img2.setImageDrawable(roundedBitmapDrawable1);


        btnbar = findViewById(R.id.btnbar);
        btnbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu_bar();
            }
        });
    }
    public void menu_bar(){
        Intent intent = new Intent(this, menuBar.class);
        startActivity(intent);
    }
    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmend"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(accueil_bar.this);
        mbuilder.setTitle("choisir un language...");
        mbuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    setLocale("fr");
                    recreate();
                }
                if(i==1){
                    setLocale("en");
                    recreate();
                }
                if(i==2) {
                    setLocale("nl");
                    recreate();
                }


            }
        });
        AlertDialog mDialog = mbuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting", MODE_PRIVATE).edit();
        editor.putString("Ma langue",lang);
        editor.apply();
    }
    public void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("Ma langue", "");
        setLocale(language);
    }
}

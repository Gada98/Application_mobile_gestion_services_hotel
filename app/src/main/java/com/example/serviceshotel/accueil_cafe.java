package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Objects;

public class accueil_cafe extends AppCompatActivity {
    Button button_cafe;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_cafe);

    //    Objects.requireNonNull(getSupportActionBar()).setTitle("accueil_café");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView img3 = findViewById(R.id.img3);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.caff);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        img3.setImageDrawable(roundedBitmapDrawable);

        ImageView img4 = findViewById(R.id.img4);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.the);
        RoundedBitmapDrawable roundedBitmapDrawable1 = RoundedBitmapDrawableFactory.create(getResources(), bitmap1);
        roundedBitmapDrawable.setCircular(true);
        img4.setImageDrawable(roundedBitmapDrawable1);

        ImageView img5 = findViewById(R.id.img5);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.jus);
        RoundedBitmapDrawable roundedBitmapDrawable2 = RoundedBitmapDrawableFactory.create(getResources(), bitmap2);
        roundedBitmapDrawable.setCircular(true);
        img5.setImageDrawable(roundedBitmapDrawable2);

        button_cafe = findViewById(R.id.button);
        button_cafe.setOnClickListener(view -> menu_cafe());
    }
    public void menu_cafe(){
        Intent intent = new Intent(this, menuCafe.class);
        startActivity(intent);
    }
    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmand"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(accueil_cafe.this);
        mbuilder.setTitle("choisir un language...");
        mbuilder.setSingleChoiceItems(listItems, -1, (dialogInterface, i) -> {
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

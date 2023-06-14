package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class menuCafe extends AppCompatActivity {
    private String lecaf1, lecaf2, lecaf3, lecaf4, lecaf5, lejus1, lejus2, lejus3, lejus4, lejus5, lethe1, lethe2, lethe3, lethe4, lethe5,
            lepr1, lepr2, lepr3, lepr4, lepr5, lepr6, lepr7, lepr8, lepr9, lepr10, lepr11, lepr12, lepr13, lepr14, lepr15;
    private TextView textcaf1, textcaf2, textcaf3, textcaf4, textcaf5, textjus1, textjus2, textjus3, textjus4, textjus5, textthe1, textthe2, textthe3, textthe4,
            textthe5, textpr1, textpr2, textpr3, textpr4, textpr5, textpr6, textpr7, textpr8, textpr9, textpr10, textpr11, textpr12, textpr13, textpr14, textpr15;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cafe);
        Objects.requireNonNull(getSupportActionBar()).setTitle("menu_café");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lecaf1 = getIntent().getStringExtra("lecaf1");
        lecaf2 = getIntent().getStringExtra("lecaf2");
        lecaf3 = getIntent().getStringExtra("lecaf3");
        lecaf4 = getIntent().getStringExtra("lecaf4");
        lecaf5 = getIntent().getStringExtra("lecaf5");
        lejus1 = getIntent().getStringExtra("lejus1");
        lejus2 = getIntent().getStringExtra("lejus2");
        lejus3 = getIntent().getStringExtra("lejus3");
        lejus4 = getIntent().getStringExtra("lejus4");
        lejus5 = getIntent().getStringExtra("lejus5");
        lethe1 = getIntent().getStringExtra("lethe1");
        lethe2 = getIntent().getStringExtra("lethe2");
        lethe3 = getIntent().getStringExtra("lethe3");
        lethe4 = getIntent().getStringExtra("lethe4");
        lethe5 = getIntent().getStringExtra("lethe5");
        lepr1 = getIntent().getStringExtra("lepr1");
        lepr2 = getIntent().getStringExtra("lepr2");
        lepr3 = getIntent().getStringExtra("lepr3");
        lepr4 = getIntent().getStringExtra("lepr4");
        lepr5 = getIntent().getStringExtra("lepr5");
        lepr6 = getIntent().getStringExtra("lepr6");
        lepr7 = getIntent().getStringExtra("lepr7");
        lepr8 = getIntent().getStringExtra("lepr8");
        lepr9 = getIntent().getStringExtra("lepr9");
        lepr10 = getIntent().getStringExtra("lepr10");
        lepr11 = getIntent().getStringExtra("lepr11");
        lepr12 = getIntent().getStringExtra("lepr12");
        lepr13 = getIntent().getStringExtra("lepr13");
        lepr14 = getIntent().getStringExtra("lepr14");
        lepr15 = getIntent().getStringExtra("lepr15");

        textcaf1 = findViewById(R.id.lecaf1);
        textcaf2 = findViewById(R.id.lecaf2);
        textcaf3 = findViewById(R.id.lecaf3);
        textcaf4 = findViewById(R.id.lecaf4);
        textcaf5 = findViewById(R.id.lecaf5);
        textjus1 = findViewById(R.id.lejus1);
        textjus2 = findViewById(R.id.lejus2);
        textjus3 = findViewById(R.id.lejus3);
        textjus4 = findViewById(R.id.lejus4);
        textjus5 = findViewById(R.id.lejus5);
        textthe1 = findViewById(R.id.lethe1);
        textthe2 = findViewById(R.id.lethe2);
        textthe3 = findViewById(R.id.lethe3);
        textthe4 = findViewById(R.id.lethe4);
        textthe5 = findViewById(R.id.lethe5);
        textpr1 = findViewById(R.id.lepr1);
        textpr2 = findViewById(R.id.lepr2);
        textpr3 = findViewById(R.id.lepr3);
        textpr4 = findViewById(R.id.lepr4);
        textpr5 = findViewById(R.id.lepr5);
        textpr6 = findViewById(R.id.lepr6);
        textpr7 = findViewById(R.id.lepr7);
        textpr8 = findViewById(R.id.lepr8);
        textpr9 = findViewById(R.id.lepr9);
        textpr10 = findViewById(R.id.lepr10);
        textpr11 = findViewById(R.id.lepr11);
        textpr12 = findViewById(R.id.lepr12);
        textpr13 = findViewById(R.id.lepr13);
        textpr14 = findViewById(R.id.lepr14);
        textpr15 = findViewById(R.id.lepr15);

        textcaf1.setText(lecaf1);
        textcaf2.setText(lecaf2);
        textcaf3.setText(lecaf3);
        textcaf4.setText(lecaf4);
        textcaf5.setText(lecaf5);
        textjus1.setText(lejus1);
        textjus2.setText(lejus2);
        textjus3.setText(lejus3);
        textjus4.setText(lejus4);
        textjus5.setText(lejus5);
        textthe1.setText(lethe1);
        textthe2.setText(lethe2);
        textthe3.setText(lethe3);
        textthe4.setText(lethe4);
        textthe5.setText(lethe5);
        textpr1.setText(lepr1);
        textpr2.setText(lepr2);
        textpr3.setText(lepr3);
        textpr4.setText(lepr4);
        textpr5.setText(lepr5);
        textpr6.setText(lepr6);
        textpr7.setText(lepr7);
        textpr8.setText(lepr8);
        textpr9.setText(lepr9);
        textpr10.setText(lepr10);
        textpr11.setText(lepr11);
        textpr12.setText(lepr12);
        textpr13.setText(lepr13);
        textpr14.setText(lepr14);
        textpr15.setText(lepr15);
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmend"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(menuCafe.this);
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

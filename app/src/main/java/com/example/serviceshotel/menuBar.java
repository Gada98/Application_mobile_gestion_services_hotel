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

public class menuBar extends AppCompatActivity {
    private String  leboiss1,leboiss2, leboiss3, leboiss4, leboiss5, leboiss6, leboiss7,
            leprix1, leprix2, leprix3, leprix4, leprix5, leprix6, leprix7,
            lechant, lemusic;
    private TextView textboiss1, textboiss2, textboiss3, textboiss4, textboiss5, textboiss6, textboiss7,
            textprix1, textprix2, textprix3, textprix4, textprix5, textprix6, textprix7,
            textchant, textmusic;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_bar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("menu_bar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leboiss1 = getIntent().getStringExtra("leboiss1");
        leboiss2 = getIntent().getStringExtra("leboiss2");
        leboiss3 = getIntent().getStringExtra("leboiss3");
        leboiss4 = getIntent().getStringExtra("leboiss4");
        leboiss5 = getIntent().getStringExtra("leboiss5");
        leboiss6 = getIntent().getStringExtra("leboiss6");
        leboiss7 = getIntent().getStringExtra("leboiss7");
        leprix1 = getIntent().getStringExtra("leprix1");
        leprix2 = getIntent().getStringExtra("leprix2");
        leprix3 = getIntent().getStringExtra("leprix3");
        leprix4 = getIntent().getStringExtra("leprix4");
        leprix5 = getIntent().getStringExtra("leprix5");
        leprix6 = getIntent().getStringExtra("leprix6");
        leprix7 = getIntent().getStringExtra("leprix7");
        lechant = getIntent().getStringExtra("lechant");
        lemusic = getIntent().getStringExtra("lemusic");

        textboiss1 = findViewById(R.id.leboiss1);
        textboiss2 = findViewById(R.id.leboiss2);
        textboiss3 = findViewById(R.id.leboiss3);
        textboiss4 = findViewById(R.id.leboiss4);
        textboiss5 = findViewById(R.id.leboiss5);
        textboiss6 = findViewById(R.id.leboiss6);
        textboiss7 = findViewById(R.id.leboiss7);
        textprix1 = findViewById(R.id.leprix1);
        textprix2 = findViewById(R.id.leprix2);
        textprix3 = findViewById(R.id.leprix3);
        textprix4 = findViewById(R.id.leprix4);
        textprix5 = findViewById(R.id.leprix5);
        textprix6 = findViewById(R.id.leprix6);
        textprix7 = findViewById(R.id.leprix7);
        textchant = findViewById(R.id.lechant);
        textmusic = findViewById(R.id.lemusic);

        textboiss1.setText(leboiss1);
        textboiss2.setText(leboiss2);
        textboiss3.setText(leboiss3);
        textboiss4.setText(leboiss4);
        textboiss5.setText(leboiss5);
        textboiss6.setText(leboiss6);
        textboiss7.setText(leboiss7);
        textprix1.setText(leprix1);
        textprix2.setText(leprix2);
        textprix3.setText(leprix3);
        textprix4.setText(leprix4);
        textprix5.setText(leprix5);
        textprix6.setText(leprix6);
        textprix7.setText(leprix7);
        textchant.setText(lechant);
        textmusic.setText(lemusic);
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmend"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(menuBar.this);
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

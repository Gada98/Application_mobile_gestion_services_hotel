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

public class menuSpa extends AppCompatActivity {
    private String leduree1, leduree2, leduree3, leduree4, leduree5,
            leprix1, leprix2, leprix3, leprix4, leprix5, leprix6;
    private TextView textduree1, textduree2, textduree3, textduree4, textduree5,
            textprix1, textprix2, textprix3, textprix4, textprix5, textprix6;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_spa);
       // Objects.requireNonNull(getSupportActionBar()).setTitle("menu_spa");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leduree1 = getIntent().getStringExtra("leduree1");
        leduree2 = getIntent().getStringExtra("leduree2");
        leduree3 = getIntent().getStringExtra("leduree3");
        leduree4 = getIntent().getStringExtra("leduree4");
        leduree5 = getIntent().getStringExtra("leduree5");
        leprix1 = getIntent().getStringExtra("leprix1");
        leprix2 = getIntent().getStringExtra("leprix2");
        leprix3 = getIntent().getStringExtra("leprix3");
        leprix4 = getIntent().getStringExtra("leprix4");
        leprix5 = getIntent().getStringExtra("leprix5");
        leprix6 = getIntent().getStringExtra("leprix6");

        textduree1 = findViewById(R.id.leduree1);
        textduree2 = findViewById(R.id.leduree2);
        textduree3 = findViewById(R.id.leduree3);
        textduree4 = findViewById(R.id.leduree4);
        textduree5 = findViewById(R.id.leduree5);
        textprix1 = findViewById(R.id.leprix1);
        textprix2 = findViewById(R.id.leprix2);
        textprix3 = findViewById(R.id.leprix3);
        textprix4 = findViewById(R.id.leprix4);
        textprix5 = findViewById(R.id.leprix5);
        textprix6 = findViewById(R.id.leprix6);

        textduree1.setText(leduree1);
        textduree2.setText(leduree2);
        textduree3.setText(leduree3);
        textduree4.setText(leduree4);
        textduree5.setText(leduree5);
        textprix1.setText(leprix1);
        textprix2.setText(leprix2);
        textprix3.setText(leprix3);
        textprix4.setText(leprix4);
        textprix5.setText(leprix5);
        textprix6.setText(leprix6);
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmend"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(menuSpa.this);
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

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

public class menuRestaurant extends AppCompatActivity {
    private String lesal1, lesal2, lesal3, lesal4, leplat1, leplat2, leplat3, leplat4, leplat5, lepoiss1, lepoiss2, lepoiss3, lediss1, lediss2, lediss3, lediss4, lediss5,
            lepr1, lepr2, lepr3, lepr4, lepr5, lepr6, lepr7, lepr8, lepr9, lepr10, lepr11, lepr12, lepr13, lepr14, lepr15, lepr16, lepr17;
    private TextView textsal1, textsal2, textsal3, textsal4, textplat1, textplat2, textplat3, textplat4, textplat5, textpoiss1, textpoiss2, textpoiss3,
            textdiss1,textdiss2,textdiss3, textdiss4, textdiss5,
            textpr1, textpr2, textpr3, textpr4, textpr5, textpr6, textpr7, textpr8, textpr9, textpr10, textpr11, textpr12, textpr13, textpr14, textpr15, textpr16, textpr17;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_restaurant);
        Objects.requireNonNull(getSupportActionBar()).setTitle("menu_restaurant");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lesal1 = getIntent().getStringExtra("lesal1");
        lesal2 = getIntent().getStringExtra("lesal2");
        lesal3 = getIntent().getStringExtra("lesal3");
        lesal4 = getIntent().getStringExtra("lesal4");
        leplat1 = getIntent().getStringExtra("leplat1");
        leplat2 = getIntent().getStringExtra("leplat2");
        leplat3 = getIntent().getStringExtra("leplat3");
        leplat4 = getIntent().getStringExtra("leplat4");
        leplat5 = getIntent().getStringExtra("leplat5");
        lepoiss1 = getIntent().getStringExtra("lepoiss1");
        lepoiss2 = getIntent().getStringExtra("lepoiss2");
        lepoiss3 = getIntent().getStringExtra("lepoiss3");
        lediss1 = getIntent().getStringExtra("lediss1");
        lediss2 = getIntent().getStringExtra("lediss2");
        lediss3 = getIntent().getStringExtra("lediss3");
        lediss4 = getIntent().getStringExtra("lediss4");
        lediss5 = getIntent().getStringExtra("lediss5");
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
        lepr16 = getIntent().getStringExtra("lepr16");
        lepr17 = getIntent().getStringExtra("lepr17");

        textsal1 = findViewById(R.id.lesal1);
        textsal2 = findViewById(R.id.lesal2);
        textsal3 = findViewById(R.id.lesal3);
        textsal4 = findViewById(R.id.lesal4);
        textplat1 = findViewById(R.id.leplat1);
        textplat2 = findViewById(R.id.leplat2);
        textplat3 = findViewById(R.id.leplat3);
        textplat4 = findViewById(R.id.leplat4);
        textplat5 = findViewById(R.id.leplat5);
        textpoiss1 = findViewById(R.id.lepoiss1);
        textpoiss2 = findViewById(R.id.lepoiss2);
        textpoiss3 = findViewById(R.id.lepoiss3);
        textdiss1 = findViewById(R.id.lediss1);
        textdiss2 = findViewById(R.id.lediss2);
        textdiss3 = findViewById(R.id.lediss3);
        textdiss4 = findViewById(R.id.lediss4);
        textdiss5 = findViewById(R.id.lediss5);
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
        textpr16 = findViewById(R.id.lepr16);
        textpr17 = findViewById(R.id.lepr17);

        textsal1.setText(lesal1);
        textsal2.setText(lesal2);
        textsal3.setText(lesal3);
        textsal4.setText(lesal4);
        textplat1.setText(leplat1);
        textplat2.setText(leplat2);
        textplat3.setText(leplat3);
        textplat4.setText(leplat4);
        textplat5.setText(leplat5);
        textpoiss1.setText(lepoiss1);
        textpoiss2.setText(lepoiss2);
        textpoiss3.setText(lepoiss3);
        textdiss1.setText(lediss1);
        textdiss2.setText(lediss2);
        textdiss3.setText(lediss3);
        textdiss4.setText(lediss4);
        textdiss5.setText(lediss5);
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
        textpr16.setText(lepr16);
        textpr17.setText(lepr17);
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allmend"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(menuRestaurant.this);
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

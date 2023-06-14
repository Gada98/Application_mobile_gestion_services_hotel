package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class accueil_client extends AppCompatActivity {
    private Button btn_rest, btn_cafe, btn_bar, btn_spa ;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_client);
        //Objects.requireNonNull(getSupportActionBar()).setTitle("accueil_client");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_rest = findViewById(R.id.btn_rest);
        btn_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restaurant();
            }
        });

        btn_cafe = findViewById(R.id.btn_cafe);
        btn_cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cafe();
            }
        });

        btn_bar= findViewById(R.id.btn_bar);
        btn_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar();
            }
        });

        btn_spa = findViewById(R.id.btn_spa);
        btn_spa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spa();
            }
        });
    }
    public void restaurant() {
        Intent intent = new Intent(this, accueil_restaurant.class);
        startActivity(intent);
    }
    public void cafe() {
        Intent intent = new Intent(this, accueil_cafe.class);
        startActivity(intent);
    }
    public void bar() {
        Intent intent = new Intent(this, accueil_bar.class);
        startActivity(intent);
    }
    public void spa() {
        Intent intent = new Intent(this, accueil_spa.class);
        startActivity(intent);
    }

}

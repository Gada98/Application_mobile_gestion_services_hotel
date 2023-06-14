package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class gerer_personnelles extends AppCompatActivity {
    Button  b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_personnelles);
       // getSupportActionBar().setTitle("gestion_personnelles");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(view -> Modifier_réceptionniste());
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(view -> Modifier_responsable());
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(view -> Modifier_chef_cuisinier());
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(view -> Supprimer_réceptionniste());
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(view -> Supprimer_responsable());
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(view -> Supprimer_chef_cuisinier());
    }

    public void Modifier_réceptionniste(){
        Intent intent = new Intent(this, modif_receptionniste.class);
        startActivity(intent);
    }
    public void Modifier_responsable(){
        Intent intent = new Intent(this, modif_responsable.class);
        startActivity(intent);
    }
    public void Modifier_chef_cuisinier(){
        Intent intent = new Intent(this, modif_chef.class);
        startActivity(intent);
    }
    public void Supprimer_réceptionniste(){
        Intent intent = new Intent(this, sup_receptionniste.class);
        startActivity(intent);
    }
    public void Supprimer_responsable(){
        Intent intent = new Intent(this, sup_responsable.class);
        startActivity(intent);
    }
    public void Supprimer_chef_cuisinier(){
        Intent intent = new Intent(this, sup_chef.class);
        startActivity(intent);
    }

}

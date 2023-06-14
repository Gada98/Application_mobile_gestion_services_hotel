package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reception extends AppCompatActivity {
    private Button button8,button9,button10,button11,button12,button13,liste_ch,liste_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);
       // getSupportActionBar().setTitle("reception");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ajouter_réservation();
            }
        });

        button9=findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ajouter_facture();
            }
        });


        button10=findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modifier_réservation();
            }
        });

        button11=findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modifier_facture();
            }
        });

        button12=findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Supprimer_réservation();
            }
        });

        button13=findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Supprimer_facture();
            }
        });

        liste_ch=findViewById(R.id.liste_ch);
        liste_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Liste_chambres();
            }
        });

        liste_f=findViewById(R.id.liste_f);
        liste_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Liste_factures();
            }
        });

    }

    public void Ajouter_réservation() {
        Intent intent = new Intent(this, ajoutReserv.class);
        startActivity(intent);
    }
    public void Ajouter_facture(){
        Intent intent = new Intent(this, ajoutFact.class);
        startActivity(intent);
    }
    public void Modifier_réservation(){
        Intent intent = new Intent(this, modifReserv.class);
        startActivity(intent);
    }
    public void Modifier_facture(){
        Intent intent = new Intent(this, modifFact.class);
        startActivity(intent);
    }
    public void Supprimer_réservation(){
        Intent intent = new Intent(this, suppReserv.class);
        startActivity(intent);
    }
    public void Supprimer_facture(){
        Intent intent = new Intent(this, suppFact.class);
        startActivity(intent);
    }
    public void Liste_chambres(){
        Intent intent = new Intent(this, listChambre.class);
        startActivity(intent);
    }
    public void Liste_factures(){
        Intent intent = new Intent(this, listFacture.class);
        startActivity(intent);
    }

}

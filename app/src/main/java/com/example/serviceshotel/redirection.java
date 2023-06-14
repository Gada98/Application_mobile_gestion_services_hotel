package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;

public class redirection extends AppCompatActivity {
    CardView id_gerant, id_responsable, id_receptionniste, id_cuisinier, id_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirection);
        id_gerant = findViewById(R.id.id_gerant);
        id_gerant.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), log_gerant.class);
            startActivity(intent);
        });
        id_responsable = findViewById(R.id.id_responsable);
        id_responsable.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), log_responsable.class);
            startActivity(intent);
        });
        id_receptionniste = findViewById(R.id.id_receptionniste);
        id_receptionniste.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), log_receptionniste.class);
            startActivity(intent);
        });
        id_cuisinier = findViewById(R.id.id_cuisinier);
        id_cuisinier.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), log_chef.class);
            startActivity(intent);
        });
        id_client = findViewById(R.id.id_client);
        id_client.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), log_client.class);
            startActivity(intent);
        });
    }
}

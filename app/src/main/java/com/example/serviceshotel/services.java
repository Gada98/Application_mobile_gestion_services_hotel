package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class services extends AppCompatActivity {
    private Button button34,button36,button37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
       // getSupportActionBar().setTitle("services");
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button34=findViewById(R.id.button34);
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Café();
            }
        });
        button36=findViewById(R.id.button36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bar();
            }
        });
        button37=findViewById(R.id.button37);
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spa();
            }
        });
    }

    public void Café(){
        Intent intent = new Intent(this, gerer_cafe.class);
        startActivity(intent);
    }
    public void Bar(){
        Intent intent = new Intent(this, gerer_bar.class);
        startActivity(intent);
    }
    public void Spa(){
        Intent intent = new Intent(this, gerer_spa.class);
        startActivity(intent);
    }
}

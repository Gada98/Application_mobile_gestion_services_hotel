package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class gerer_restaurant extends AppCompatActivity {
    private EditText sal1, sal2, sal3, sal4, plat1, plat2, plat3, plat4, plat5, poiss1, poiss2, poiss3, diss1, diss2, diss3, diss4, diss5,
            pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14, pr15, pr16, pr17;
    private Button button38;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID=001;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_restaurant);
       // Objects.requireNonNull(getSupportActionBar()).setTitle("gestion_restaurant");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sal1 = findViewById(R.id.sal1);
        sal2 = findViewById(R.id.sal2);
        sal3 = findViewById(R.id.sal3);
        sal4 = findViewById(R.id.sal4);
        plat1 = findViewById(R.id.plat1);
        plat2 = findViewById(R.id.plat2);
        plat3 = findViewById(R.id.plat3);
        plat4 = findViewById(R.id.plat4);
        plat5 = findViewById(R.id.plat5);
        poiss1 = findViewById(R.id.poiss1);
        poiss2 = findViewById(R.id.poiss2);
        poiss3 = findViewById(R.id.poiss3);
        diss1 = findViewById(R.id.diss1);
        diss2 = findViewById(R.id.diss2);
        diss3 = findViewById(R.id.diss3);
        diss4 = findViewById(R.id.diss4);
        diss5 = findViewById(R.id.diss5);
        pr1 = findViewById(R.id.pr1);
        pr2 = findViewById(R.id.pr2);
        pr3 = findViewById(R.id.pr3);
        pr4 = findViewById(R.id.pr4);
        pr5 = findViewById(R.id.pr5);
        pr6 = findViewById(R.id.pr6);
        pr7 = findViewById(R.id.pr7);
        pr8 = findViewById(R.id.pr8);
        pr9 = findViewById(R.id.pr9);
        pr10 = findViewById(R.id.pr10);
        pr11 = findViewById(R.id.pr11);
        pr12 = findViewById(R.id.pr12);
        pr13 = findViewById(R.id.pr13);
        pr14 = findViewById(R.id.pr14);
        pr15 = findViewById(R.id.pr15);
        pr16 = findViewById(R.id.pr16);
        pr17 = findViewById(R.id.pr17);
        button38=findViewById(R.id.button38);
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String saisirsal1 = sal1.getText().toString();
                final String saisirsal2 = sal2.getText().toString();
                final String saisirsal3 = sal3.getText().toString();
                final String saisirsal4 = sal4.getText().toString();
                final String saisirplat1 = plat1.getText().toString();
                final String saisirplat2 = plat2.getText().toString();
                final String saisirplat3 = plat3.getText().toString();
                final String saisirplat4 = plat4.getText().toString();
                final String saisirplat5 = plat5.getText().toString();
                final String saisirpoiss1 = poiss1.getText().toString();
                final String saisirpoiss2 = poiss2.getText().toString();
                final String saisirpoiss3 = poiss3.getText().toString();
                final String saisirdiss1 = diss1.getText().toString();
                final String saisirdiss2 = diss2.getText().toString();
                final String saisirdiss3 = diss3.getText().toString();
                final String saisirdiss4 = diss4.getText().toString();
                final String saisirdiss5 = diss5.getText().toString();
                final String saisirpr1 = pr1.getText().toString();
                final String saisirpr2 = pr2.getText().toString();
                final String saisirpr3 = pr3.getText().toString();
                final String saisirpr4 = pr4.getText().toString();
                final String saisirpr5 = pr5.getText().toString();
                final String saisirpr6 = pr6.getText().toString();
                final String saisirpr7 = pr7.getText().toString();
                final String saisirpr8 = pr8.getText().toString();
                final String saisirpr9 = pr9.getText().toString();
                final String saisirpr10 = pr10.getText().toString();
                final String saisirpr11 = pr11.getText().toString();
                final String saisirpr12 = pr12.getText().toString();
                final String saisirpr13 = pr13.getText().toString();
                final String saisirpr14 = pr14.getText().toString();
                final String saisirpr15 = pr15.getText().toString();
                final String saisirpr16 = pr16.getText().toString();
                final String saisirpr17 = pr17.getText().toString();
                Toast.makeText(getApplicationContext(),""+saisirsal1+"\n"+saisirsal2+"\n"+saisirsal3+"\n"+saisirsal4+"\n"+saisirplat1+"\n"+
                        saisirplat2+"\n"+saisirplat3+"\n"+saisirplat4+"\n"+saisirplat5+"\n"+saisirpoiss1+"\n"+
                        saisirpoiss2+"\n"+saisirpoiss3+"\n"+saisirdiss1+"\n"+saisirdiss2+"\n"+saisirdiss3+"\n"+saisirdiss4+"\n"+saisirdiss5+"\n"+saisirpr1+"\n"+saisirpr2+"\n"+saisirpr3+"\n"+
                        saisirpr4+"\n"+saisirpr5+"\n"+saisirpr6+"\n"+saisirpr7+"\n"+saisirpr8+"\n"+saisirpr9+"\n"+saisirpr10+"\n"+saisirpr11+"\n"+
                        saisirpr12+"\n"+saisirpr13+"\n"+saisirpr14+"\n"+saisirpr15+"\n"+saisirpr16+"\n"+saisirpr17, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(gerer_restaurant.this, menuRestaurant.class);
                intent.putExtra("sal1",saisirsal1);
                intent.putExtra("sal2",saisirsal2);
                intent.putExtra("sal3",saisirsal3);
                intent.putExtra("sal4",saisirsal4);
                intent.putExtra("plat1",saisirplat1);
                intent.putExtra("plat2",saisirplat2);
                intent.putExtra("plat3",saisirplat3);
                intent.putExtra("plat4",saisirplat4);
                intent.putExtra("plat5",saisirplat5);
                intent.putExtra("poiss1",saisirpoiss1);
                intent.putExtra("poiss2",saisirpoiss2);
                intent.putExtra("poiss3",saisirpoiss3);
                intent.putExtra("diss1",saisirdiss1);
                intent.putExtra("diss2",saisirdiss2);
                intent.putExtra("diss3",saisirdiss3);
                intent.putExtra("diss4",saisirdiss4);
                intent.putExtra("diss5",saisirdiss5);
                intent.putExtra("pr1",saisirpr1);
                intent.putExtra("pr2",saisirpr2);
                intent.putExtra("pr3",saisirpr3);
                intent.putExtra("pr4",saisirpr4);
                intent.putExtra("pr5",saisirpr5);
                intent.putExtra("pr6",saisirpr6);
                intent.putExtra("pr7",saisirpr7);
                intent.putExtra("pr8",saisirpr8);
                intent.putExtra("pr9",saisirpr9);
                intent.putExtra("pr10",saisirpr10);
                intent.putExtra("pr11",saisirpr11);
                intent.putExtra("pr12",saisirpr13);
                intent.putExtra("pr14",saisirpr14);
                intent.putExtra("pr15",saisirpr15);
                intent.putExtra("pr16",saisirpr16);
                intent.putExtra("pr17",saisirpr17);
                startActivity(intent);
                Enregistrer();
            }
        });
    }

    private void Enregistrer() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setContentTitle("Notification de menu");
        builder.setContentText("Il y a un mise à jour de menu");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }
}

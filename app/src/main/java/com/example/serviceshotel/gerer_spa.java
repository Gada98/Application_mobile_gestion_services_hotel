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
public class gerer_spa extends AppCompatActivity {
     Button btnSpa;
    private EditText duree1, duree2, duree3, duree4, duree5, prix1, prix2, prix3, prix4, prix5, prix6;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID=001;


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_gerer_spa);
        //getSupportActionBar().setTitle("gestion_spa");
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        duree1 = findViewById(R.id.duree1);
        duree2 = findViewById(R.id.duree2);
        duree3 = findViewById(R.id.duree3);
        duree4 = findViewById(R.id.duree4);
        duree5 = findViewById(R.id.duree5);
        prix1 = findViewById(R.id.prix1);
        prix2 = findViewById(R.id.prix2);
        prix3 = findViewById(R.id.prix3);
        prix4 = findViewById(R.id.prix4);
        prix5 = findViewById(R.id.prix5);
        prix6 = findViewById(R.id.prix6);

        btnSpa=findViewById(R.id.button4);

        btnSpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String saisirduree1 = duree1.getText().toString();
                final String saisirduree2 = duree2.getText().toString();
                final String saisirduree3 = duree3.getText().toString();
                final String saisirduree4 = duree4.getText().toString();
                final String saisirduree5 = duree5.getText().toString();
                final String saisirprix1 = prix1.getText().toString();
                final String saisirprix2 = prix2.getText().toString();
                final String saisirprix3 = prix3.getText().toString();
                final String saisirprix4 = prix4.getText().toString();
                final String saisirprix5 = prix5.getText().toString();
                final String saisirprix6 = prix6.getText().toString();
                Toast.makeText(getApplicationContext(),""+saisirduree1+"\n"+saisirduree2+"\n"+saisirduree3+"\n"+saisirduree4+"\n"+saisirduree5+"\n"
                        +saisirprix1+"\n"+saisirprix2+"\n"+saisirprix3+"\n"+saisirprix4+"\n"+saisirprix5+"\n"+saisirprix6, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(gerer_spa.this, menuSpa.class );
                intent.putExtra("duree1",saisirduree1);
                intent.putExtra("duree2",saisirduree2);
                intent.putExtra("duree3",saisirduree3);
                intent.putExtra("duree4",saisirduree4);
                intent.putExtra("duree5",saisirduree5);
                intent.putExtra("leprix1",saisirprix1);
                intent.putExtra("leprix2",saisirprix2);
                intent.putExtra("leprix3",saisirprix3);
                intent.putExtra("leprix4",saisirprix4);
                intent.putExtra("leprix5",saisirprix5);
                intent.putExtra("leprix6",saisirprix6);
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

package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gerer_bar extends AppCompatActivity {
    private Button button35;
    private EditText boiss1, boiss2, boiss3, boiss4, boiss5, boiss6, boiss7,
            prix1, prix2, prix3, prix4, prix5, prix6, prix7,
            chant, music;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID=001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_bar);
       // getSupportActionBar().setTitle("gestion_bar");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boiss1=findViewById(R.id.boiss1);
        boiss2 = findViewById(R.id.boiss2);
        boiss3 = findViewById(R.id.boiss3);
        boiss4 = findViewById(R.id.boiss4);
        boiss5 = findViewById(R.id.boiss5);
        boiss6 = findViewById(R.id.boiss6);
        boiss7 = findViewById(R.id.boiss7);
        prix1 = findViewById(R.id.prix1);
        prix2 = findViewById(R.id.prix2);
        prix3 = findViewById(R.id.prix3);
        prix4 = findViewById(R.id.prix4);
        prix5 = findViewById(R.id.prix5);
        prix6 = findViewById(R.id.prix6);
        prix7 = findViewById(R.id.prix7);
        chant = findViewById(R.id.chant);
        music = findViewById(R.id.music);


        button35=findViewById(R.id.button35);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String saisirboiss1 = boiss1.getText().toString();
                final String saisirboiss2 = boiss2.getText().toString();
                final String saisirboiss3 = boiss3.getText().toString();
                final String saisirboiss4 = boiss4.getText().toString();
                final String saisirboiss5 = boiss5.getText().toString();
                final String saisirboiss6 = boiss6.getText().toString();
                final String saisirboiss7 = boiss7.getText().toString();
                final String saisirprix1 = prix1.getText().toString();
                final String saisirprix2 = prix2.getText().toString();
                final String saisirprix3 = prix3.getText().toString();
                final String saisirprix4 = prix4.getText().toString();
                final String saisirprix5 = prix5.getText().toString();
                final String saisirprix6 = prix6.getText().toString();
                final String saisirprix7 = prix7.getText().toString();
                final String saisirchant = chant.getText().toString();
                final String saisirmusic = music.getText().toString();
                Toast.makeText(getApplicationContext(),""+saisirboiss1+"\n"+saisirboiss2+"\n"+saisirboiss3+"\n"+saisirboiss4+"\n"+saisirboiss5+"\n"+
                        saisirboiss6+"\n"+saisirboiss7+"\n"+
                        saisirprix1+"\n"+saisirprix2+"\n"+saisirprix3+"\n"+saisirprix4+"\n"+saisirprix5+"\n"+saisirprix6+"\n"+saisirprix7+"\n"+
                       "\n"+saisirchant+"\n"+saisirmusic, Toast.LENGTH_LONG).show();

                Intent intent= new Intent(gerer_bar.this, menuBar.class );
                intent.putExtra("leboiss1",saisirboiss1);
                intent.putExtra("leboiss2",saisirboiss2);
                intent.putExtra("leboiss3",saisirboiss3);
                intent.putExtra("leboiss4",saisirboiss4);
                intent.putExtra("leboiss5",saisirboiss5);
                intent.putExtra("leboiss6",saisirboiss6);
                intent.putExtra("leboiss7",saisirboiss7);
                intent.putExtra("leprix1",saisirprix1);
                intent.putExtra("leprix2",saisirprix2);
                intent.putExtra("leprix3",saisirprix3);
                intent.putExtra("leprix4",saisirprix4);
                intent.putExtra("leprix5",saisirprix5);
                intent.putExtra("leprix6",saisirprix6);
                intent.putExtra("leprix7",saisirprix7);
                intent.putExtra("lechant",saisirchant);
                intent.putExtra("lemusic",saisirmusic);
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

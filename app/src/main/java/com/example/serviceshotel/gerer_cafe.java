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

public class gerer_cafe extends AppCompatActivity {
    private EditText caf1, caf2, caf3, caf4, caf5, jus1, jus2, jus3, jus4, jus5, the1, the2, the3, the4, the5,
            pr1, pr2, pr3, pr4, pr5, pr6, pr7, pr8, pr9, pr10, pr11, pr12, pr13, pr14, pr15;
    private Button button38;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID=001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer_cafe);
       // getSupportActionBar().setTitle("gestion_cafe");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        caf1 = findViewById(R.id.caf1);
        caf2 = findViewById(R.id.caf2);
        caf3 = findViewById(R.id.caf3);
        caf4 = findViewById(R.id.caf4);
        caf5 = findViewById(R.id.caf5);
        jus1 = findViewById(R.id.jus1);
        jus2 = findViewById(R.id.jus2);
        jus3 = findViewById(R.id.jus3);
        jus4 = findViewById(R.id.jus4);
        jus5 = findViewById(R.id.jus5);
        the1 = findViewById(R.id.the1);
        the2 = findViewById(R.id.the2);
        the3 = findViewById(R.id.the3);
        the4 = findViewById(R.id.the4);
        the5 = findViewById(R.id.the5);
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
        button38=findViewById(R.id.button38);
        button38.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                final String saisircaf1 = caf1.getText().toString();
                final String saisircaf2 = caf2.getText().toString();
                final String saisircaf3 = caf3.getText().toString();
                final String saisircaf4 = caf4.getText().toString();
                final String saisircaf5 = caf5.getText().toString();
                final String saisirjus1 = jus1.getText().toString();
                final String saisirjus2 = jus2.getText().toString();
                final String saisirjus3 = jus3.getText().toString();
                final String saisirjus4 = jus4.getText().toString();
                final String saisirjus5 = jus5.getText().toString();
                final String saisirthe1 = the1.getText().toString();
                final String saisirthe2 = the2.getText().toString();
                final String saisirthe3 = the3.getText().toString();
                final String saisirthe4 = the4.getText().toString();
                final String saisirthe5 = the5.getText().toString();
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
                Toast.makeText(getApplicationContext(),""+saisircaf1+"\n"+saisircaf2+"\n"+saisircaf3+"\n"+saisircaf4+"\n"+saisircaf5+"\n"+
                        saisirjus1+"\n"+saisirjus2+"\n"+saisirjus3+"\n"+saisirjus4+"\n"+saisirjus5+"\n"+
                        saisirthe1+"\n"+saisirthe2+"\n"+saisirthe3+"\n"+saisirthe4+"\n"+saisirthe5+"\n"+saisirpr1+"\n"+saisirpr2+"\n"+saisirpr3+"\n"+
                        saisirpr4+"\n"+saisirpr5+"\n"+saisirpr6+"\n"+saisirpr7+"\n"+saisirpr8+"\n"+saisirpr9+"\n"+saisirpr10+"\n"+saisirpr11+"\n"+
                        saisirpr12+"\n"+saisirpr13+"\n"+saisirpr14+"\n"+saisirpr15, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(gerer_cafe.this, menuCafe.class);
                intent.putExtra("caf1",saisircaf1);
                intent.putExtra("caf2",saisircaf2);
                intent.putExtra("caf3",saisircaf3);
                intent.putExtra("caf4",saisircaf4);
                intent.putExtra("caf5",saisircaf5);
                intent.putExtra("jus1",saisirjus1);
                intent.putExtra("jus2",saisirjus2);
                intent.putExtra("jus3",saisirjus3);
                intent.putExtra("jus4",saisirjus4);
                intent.putExtra("jus5",saisirjus5);
                intent.putExtra("the1",saisirthe1);
                intent.putExtra("the2",saisirthe2);
                intent.putExtra("the3",saisirthe3);
                intent.putExtra("the4",saisirthe4);
                intent.putExtra("the5",saisirthe5);
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

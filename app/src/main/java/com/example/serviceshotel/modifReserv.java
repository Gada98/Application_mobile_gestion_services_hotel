package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class modifReserv extends AppCompatActivity {
    String URLServeur ="http://192.168.43.175/test/modif_reserv.php";
    ProgressDialog pDialog ;
    TextView txt_vw;
    EditText ed_nom, ed_prénom, ed_nChambre, ed_reservation, ed_arrive, ed_depart;
    Button btn_modif;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_reserv);
        getSupportActionBar().setTitle("modifier_reservation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_vw = findViewById(R.id.txt_vw);
        ed_nom = findViewById(R.id.ed_nom);
        ed_prénom = findViewById(R.id.ed_prénom);
        ed_nChambre = findViewById(R.id.ed_nChambre);
        ed_reservation = findViewById(R.id.ed_reservation);
        ed_arrive = findViewById(R.id.ed_arrive);
        ed_depart = findViewById(R.id.ed_depart);
        int type = radioGroup.getCheckedRadioButtonId();
        RadioButton selected_type = radioGroup.findViewById(type);
        if (selected_type == null){
            Toast.makeText(modifReserv.this, "Select type s'il vous plait", Toast.LENGTH_LONG).show();
        }
        else{
            String selectdType = selected_type.getText().toString();
        }
        btn_modif = findViewById(R.id.btn_ajout);
        btn_modif.setOnClickListener((view) ->{
            if ((ed_nom.getText().toString().equals(""))||(ed_prénom.getText().toString().equals(""))||(ed_nChambre.getText().toString().equals(""))||(ed_reservation.getText().toString().equals(""))||
                    (ed_arrive.getText().toString().equals(""))||(ed_depart.getText().toString().equals(""))) {
                Toast.makeText(modifReserv.this, "Entrer les données s'il vous plait", Toast.LENGTH_SHORT).show();
            } else
                new Webservice().execute(URLServeur, ed_nom.getText().toString(), ed_prénom.getText().toString(), ed_nChambre.getText().toString(),
                        ed_reservation.getText().toString(), ed_reservation.getText().toString(), ed_arrive.getText().toString(), ed_depart.getText().toString());
        });
    }
    class Webservice extends AsyncTask<String, Void,String> {
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(modifReserv.this);
            pDialog.setMessage("connexion au serveur..");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... strings){
            StringBuilder result = new StringBuilder();
            try {
                HttpURLConnection conn;
                URL url = new URL(strings[0]);
                String ID=strings[1];
                String NOM=strings[2];
                String PRENOM=strings[3];
                String DATE_RESERVATION=strings[4];
                String DATE_ARRIVE=strings[5];
                String DATE_DEPART=strings[6];
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(1000);

                Uri.Builder builder = new Uri.Builder().appendQueryParameter("id",ID).appendQueryParameter("nom",NOM).appendQueryParameter("prénom",PRENOM).appendQueryParameter("date_reservation",DATE_RESERVATION).appendQueryParameter("date_arrive",DATE_ARRIVE).appendQueryParameter("date_départ",DATE_DEPART);
                String requete = builder.build().getEncodedQuery();
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                writer.write(requete);
                writer.flush();
                writer.close();
                outputStream.close();

                conn.connect();

                InputStream inputStream =new BufferedInputStream(conn.getInputStream());
                BufferedReader reader =new BufferedReader((new InputStreamReader(inputStream)));
                String ligne;
                while ((ligne=reader.readLine())!=null){
                    result.append(ligne);
                }
                conn.disconnect();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return result.toString();
        }
        @Override
        protected void onPostExecute(String string){
            pDialog.dismiss();
            txt_vw.setText(string);
        }
    }
}



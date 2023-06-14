package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

public class modifFact extends AppCompatActivity {
    String URLServeur ="http://192.168.43.175/test/modif_fact.php";
    ProgressDialog pDialog ;
    TextView txt_vw;
    EditText ed_id, ed_nom, ed_prénom, ed_montant;
    Button btn_modif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_fact);
        getSupportActionBar().setTitle("modifier_facture");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_vw = findViewById(R.id.txt_vw);
        ed_id = findViewById(R.id.ed_id);
        ed_nom = findViewById(R.id.ed_nom);
        ed_prénom = findViewById(R.id.ed_prénom);
        ed_montant = findViewById(R.id.ed_montant);

        btn_modif.setOnClickListener((view) -> {
            if (ed_id.getText().toString().equals("") || ed_nom.getText().toString().equals("") || ed_prénom.getText().toString().equals("") || ed_montant.getText().toString().equals("")) {
                Toast.makeText(modifFact.this, "Entrer les données s'il vous plait", Toast.LENGTH_SHORT).show();
            } else
                new Webservice().execute(URLServeur, ed_id.getText().toString(), ed_nom.getText().toString(), ed_prénom.getText().toString(), ed_montant.getText().toString());
        });
    }
    class Webservice extends AsyncTask<String, Void,String> {
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(modifFact.this);
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
                String MONTANT=strings[4];
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(1000);

                Uri.Builder builder = new Uri.Builder().appendQueryParameter("id",ID).appendQueryParameter("nom",NOM).appendQueryParameter("prénom",PRENOM).appendQueryParameter("montant",MONTANT);
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


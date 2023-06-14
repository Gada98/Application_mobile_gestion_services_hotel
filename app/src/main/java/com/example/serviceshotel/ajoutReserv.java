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

public class ajoutReserv extends AppCompatActivity {
    String URLServeur ="http://192.168.43.175/test/ajout_reserv.php";
    ProgressDialog pDialog ;
    TextView txt_vw;
    EditText ed_nom, ed_prénom, ed_nChambre, ed_reservation, ed_arrive, ed_depart;
    Button btn_ajout;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_reserv);
        //getSupportActionBar().setTitle("ajouter_reservation");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_vw = findViewById(R.id.txt_vw);
        ed_nom = findViewById(R.id.ed_nom);
        ed_prénom = findViewById(R.id.ed_prénom);
        ed_nChambre = findViewById(R.id.ed_nChambre);
        ed_reservation = findViewById(R.id.ed_reservation);
        ed_arrive = findViewById(R.id.ed_arrive);
        ed_depart = findViewById(R.id.ed_depart);
        int type = radioGroup.getCheckedRadioButtonId();
        RadioButton selected_type = radioGroup.findViewById(R.id.type);
        if (selected_type == null){
            Toast.makeText(ajoutReserv.this, "Select type s'il vous plait", Toast.LENGTH_LONG).show();
        }
        else{
            String selectdType = selected_type.getText().toString();
        }
        btn_ajout = findViewById(R.id.btn_ajout);
        btn_ajout.setOnClickListener((view) ->{
            if ((ed_nom.getText().equals(""))&(ed_prénom.getText().equals(""))&(ed_nChambre.getText().equals(""))&(ed_reservation.getText().equals(""))&
                    (ed_arrive.getText().equals(""))&(ed_depart.getText().equals(""))) {
                Toast.makeText(ajoutReserv.this, "Entrer les données s'il vous plait", Toast.LENGTH_SHORT).show();
            } else
                new Webservice().execute(URLServeur, ed_nom.getText().toString(), ed_prénom.getText().toString(), ed_nChambre.getText().toString(),
                        ed_reservation.getText().toString(), ed_reservation.getText().toString(), ed_arrive.getText().toString(), ed_depart.getText().toString());
        });
    }
    class Webservice extends AsyncTask<String, Void,String> {
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(ajoutReserv.this);
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
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(1000);

                Uri.Builder builder = new Uri.Builder().appendQueryParameter("id",ID);
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


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

public class ajout_chef extends AppCompatActivity {
    String URLServeur ="http://51.255.106.21/test/ajout_chef.php";
    ProgressDialog pDialog ;
    TextView txt_vw;
    EditText ed_nom, ed_prénom, ed_nat, ed_cin, ed_adresse, ed_telephone, ed_email, ed_psd, ed_mdp;
    Button btn_ajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_chef);
        txt_vw = findViewById(R.id.txt_vw);
        ed_nom = findViewById(R.id.ed_nom);
        ed_prénom = findViewById(R.id.ed_prénom);
        ed_nat = findViewById(R.id.ed_nat);
        ed_cin = findViewById(R.id.ed_cin);
        ed_adresse = findViewById(R.id.adresse);
        ed_telephone = findViewById(R.id.ed_telephone);
        ed_email = findViewById(R.id.ed_email);
        ed_psd = findViewById(R.id.ed_psd);
        ed_mdp = findViewById(R.id.ed_mdp);
        btn_ajout = findViewById(R.id.btn_ajout);

        btn_ajout.setOnClickListener((view) ->{
            if (ed_nom.getText().equals("")) {
                Toast.makeText(ajout_chef.this, "Entrer les données s'il vous plait", Toast.LENGTH_SHORT).show();
            } else
                new Webservice().execute(URLServeur, ed_nom.getText().toString(), ed_prénom.getText().toString(), ed_nat.getText().toString(), ed_adresse.getText().toString(),
                        ed_telephone.getText().toString(), ed_email.getText().toString(), ed_psd.getText().toString(), ed_mdp.getText().toString());
        });
    }

    class Webservice extends AsyncTask<String, Void,String> {
        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(ajout_chef.this);
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



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
import java.util.Objects;

public class sup_responsable extends AppCompatActivity {
    String UrlServer="http://51.255.106.21/supp_responsable.php";
    ProgressDialog progressDialog;
    TextView txtv;
    EditText ed_id;
    Button btn_sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_responsable);
        Objects.requireNonNull(getSupportActionBar()).setTitle("supprimer_responsable");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtv =findViewById(R.id.txtv);
        ed_id =findViewById(R.id.ed_fact);
        btn_sup =findViewById(R.id.btn_supfact);
        btn_sup.setOnClickListener((view) -> {
            if(ed_id.getText().toString().equals("")){
                Toast.makeText(sup_responsable.this,"Entre un ID s'il vous plait",Toast.LENGTH_SHORT).show();
            }
            else
                new Webservice().execute(UrlServer,ed_id.getText().toString());
        });
    }
    class Webservice extends AsyncTask<String, Void,String> {
        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(sup_responsable.this);
            progressDialog.setMessage("connexion au serveur..");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
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
            progressDialog.dismiss();
            txtv.setText(string);
        }
    }
}

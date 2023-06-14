package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.serviceshotel.utils.Receptionniste;
import com.example.serviceshotel.utils.SessionHandler1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class log_receptionniste extends AppCompatActivity {
    Button btn_inscrit;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    private EditText etEmail;
    private EditText etPassword;
    private SessionHandler1 sessionHandler1 ;
    private String Pseudo , Mot_de_passe ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_receptionniste);
        etEmail = findViewById(R.id.Pseudo);
        etPassword =findViewById(R.id.Mot_de_passe);

        btn_inscrit = findViewById(R.id.btn_inscrit);
        btn_inscrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), inscrit_receptionniste.class);
                startActivity(intent);
            }
        });
        sessionHandler1 = new SessionHandler1(this);

    }
    public void checkLogin(View arg0) {

        Pseudo = etEmail.getText().toString();
        if (!isValidEmail(Pseudo)) {
            etEmail.setError("Invalid Email");
        }
        Mot_de_passe = etPassword.getText().toString();
        if (!isValidPassword(Mot_de_passe)) {
            etPassword.setError("Password cannot be empty");
        }
        if(isValidEmail(Pseudo) && isValidPassword(Mot_de_passe))
        {
        }

        new AsyncLogin().execute(Pseudo,Mot_de_passe);

    }
    private boolean isValidEmail(String Pseudo) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(Pseudo);
        return matcher.matches();
    }

    private boolean isValidPassword(String Mot_de_passe) {
        if (Mot_de_passe != null && Mot_de_passe.length() >= 4) {
            return true;
        }
        return false;
    }
    private class AsyncLogin extends AsyncTask<String, String, String>
    {
        ProgressDialog pdLoading = new ProgressDialog(log_receptionniste.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }
        @Override
        protected String doInBackground(String... params) {

            try {
                url = new URL("http://192.168.43.175:8080/test/log_receptionniste.php");

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "exception";
            }
            try {

                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("Pseudo", params[0])
                        .appendQueryParameter("Mot_de_passe", params[1]);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    return(result.toString());

                }else{

                    return("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            pdLoading.dismiss();

            if(result.equalsIgnoreCase("true"))

            {
                Receptionniste receptionniste = new Receptionniste(Pseudo,Mot_de_passe);
                sessionHandler1.LoginReceptionniste(receptionniste);

                Intent intent = new Intent(log_receptionniste.this,profReceptionniste.class);
                startActivity(intent);
                log_receptionniste.this.finish();

            }else if (result.equalsIgnoreCase("false")){
                Toast.makeText(log_receptionniste.this, "Invalid email or password", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(log_receptionniste.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }

    }
}


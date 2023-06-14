package com.example.serviceshotel;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{6,}" +
                    "$");

    private Button btn_cnx, button2, btn_client;
    TextView txt_view;
    EditText pseud, passwd;
    connexionTask jsonParser = new connexionTask();
    private static String url_create_product = "http://51.255.106.21/code.php";
    private static final String TAG_SUCCESS = "success";
    AlertDialog.Builder alert;
    JSONObject json;
    int success;
    private ProgressDialog pDialog;
    private View v;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInatanceState) {
        super.onCreate(savedInatanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).setTitle("authentification");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        pseud = findViewById(R.id.etpseud);
        passwd = findViewById(R.id.etpass);

        btn_cnx = findViewById(R.id.btn_cnx);
        btn_cnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connecter();
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscrire();
            }
        });
        btn_client = findViewById(R.id.button);
        btn_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                espace_client();
            }
        });
        txt_view = findViewById(R.id.txt_view);
        txt_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, modMDP.class);
                startActivity(intent);
                Toast.makeText(login.this, "texte clicked", Toast.LENGTH_LONG).show();
            }
             });

    }

    class connexionTask extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(login.this);
            pDialog.setMessage("Login");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... args) {

            String email = pseud.getText().toString();
            String pass = passwd.getText().toString();


            HashMap<String, String> param = new HashMap<String, String>();
            param.put("mail", email);
            param.put("pass", pass);


            Object params = null;
            JSONObject json = jsonParser.makeHttpRequest(url_create_product, "POST", params);
            Log.d("connexion", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {


                    Intent i = new Intent(getApplicationContext(), connexionTask.class);
                    i.putExtra("email", email);

                    startActivity(i);


                } else {
                    alert = new AlertDialog.Builder(login.this);
                    alert.setMessage("email ou mot de passe incorrecte.Réessayer");
                    alert.setNeutralButton("ok", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            dialog.dismiss();
                        }
                    });

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        private JSONObject makeHttpRequest(String url_create_product, String post, Object params) {
            return makeHttpRequest(url_create_product, "POST", params);}
        protected void onPostExecute(String file_url) {

            pDialog.dismiss();

            if (success==0)
            {
                alert.show();
            }
        }
    }

    public void Connecter() {

    }

    public void inscrire() {
        Intent intent = new Intent(this, inscription.class);
        startActivity(intent);
    }

    public void espace_client() {
        Intent intent = new Intent(this, accueil_client.class);
        startActivity(intent);
    }



    private boolean validateEmail() {
        String EmailInput = pseud.getText().toString().trim();
        if (EmailInput.isEmpty()) {
            pseud.setError("Email invalide");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(EmailInput).matches()) {
            if (EmailInput.isEmpty()) {
                pseud.setError("Entrer email correct");
                return false;

            } else {
                pseud.setError(null);
                return true;
            }
        }
        return validateEmail();
    }

    private boolean validatePassword() {
        String PasswordInput = passwd.getText().toString().trim();
        if (PasswordInput.isEmpty()) {
            passwd.setError("Password invalide");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(PasswordInput).matches()) {
            passwd.setError(null);
            return true;
        }
        return validatePassword();
    }

    public void confirmInput(View v) {
        if (!validateEmail() || !validatePassword()) {
            return;
        }

        String input = "Email" + pseud.getText().toString();
        input += "\n";
        input += "Password" + passwd.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }

}


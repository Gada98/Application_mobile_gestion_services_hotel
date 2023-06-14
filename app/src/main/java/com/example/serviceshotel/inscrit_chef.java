package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;


/*inscription de chef cuisiner*/
public class inscrit_chef extends AppCompatActivity {
    TextView lang;
    Button reg;
    EditText txtNom, txtPrenom, txtNat, txtCin, txtAdd, txtTele, txtEmail, txtPsd, txtMdp;
    String nom;
    String prénom;
    String nationalité;
    String N_CIN;
    String adresse;
    String numéro_téléphone;
    String email;
    String Pseudo;
    String Mot_de_passe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrit_chef);

        reg = findViewById(R.id.reg);
        txtNom = findViewById(R.id.nom);
        txtPrenom = findViewById(R.id.prénom);
        txtNat = findViewById(R.id.nationalité);
        txtCin = findViewById(R.id.N_CIN);
        txtAdd = findViewById(R.id.adresse);
        txtTele = findViewById(R.id.numéro_téléphone);
        txtEmail = findViewById(R.id.email);
        txtPsd = findViewById(R.id.Pseudo);
        txtMdp = findViewById(R.id.Mot_de_passe);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = txtNom.getText().toString().trim();
                prénom = txtPrenom.getText().toString().trim();
                nationalité = txtNat.getText().toString().trim();
                N_CIN = txtCin.getText().toString().trim();
                adresse = txtAdd.getText().toString().trim();
                numéro_téléphone = txtTele.getText().toString().trim();
                email = txtNom.getText().toString().trim();
                Pseudo = txtPsd.getText().toString().trim();
                Mot_de_passe = txtMdp.getText().toString().trim();
                backgroundTask1 back = new backgroundTask1(getApplicationContext());
                back.execute(nom, prénom, nationalité, N_CIN, adresse, numéro_téléphone, email, Pseudo, Mot_de_passe);
                if(!validate()){
                    Toast.makeText(inscrit_chef.this, "l'inscription a echoué",Toast.LENGTH_SHORT).show();
                }
                else {
                    onSingupSuccess();

                    //inscri dsla base

                    Intent intent = new Intent(inscrit_chef.this, log_chef.class);
                    startActivity(intent);
                }

            }
        });


        lang = findViewById(R.id.lang);
        lang.setOnClickListener(v -> showChangeLanguageDialog());
    }


    public void onSingupSuccess() {}
    public boolean validate() {
        boolean valid = true;
        if ((nom.isEmpty())&(nom.length() < 30)) {
            txtNom.setError("\n" + "veuillez entrer un nom valide");
            valid = false;
        }
        if ((prénom.isEmpty())&(prénom.length() < 30)) {
            txtPrenom.setError("\n" + "veuillez entrer un prenom valide");
            valid = false;
        }
        if ((nationalité.isEmpty())&(nationalité.length() < 30)) {
            txtNat.setError("\n" + "veuillez entrer une nationalité valide");
            valid = false;
        }
        if (N_CIN.isEmpty()) {
            txtCin.setError("\n" + "veuillez entrer un numéro CIN valide");
            valid = false;
        }
        if ((adresse.isEmpty())&(adresse.length() < 50)) {
            txtAdd.setError("\n" + "veuillez entrer une adresse valide");
            valid = false;
        }
        if (numéro_téléphone.isEmpty()) {
            txtTele.setError("\n" + "veuillez entrer un numéro de téléphone valide");
            valid = false;
        }
        if ((email.isEmpty())&(email.length() < 100)) {
            txtEmail.setError("\n" + "veuillez entrer un email valide");
            valid = false;
        }
        if (Pseudo.isEmpty()) {
            txtPsd.setError("\n" + "veuillez entrer un pseudo valide");
            valid = false;
        }
        if (Mot_de_passe.isEmpty()) {
            txtMdp.setError("\n" + "veuillez entrer une mot de passe valide");
            valid = false;
        }

        return valid;

    }



    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allemand", "espagnol"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(inscrit_chef.this);
        mbuilder.setTitle("choisir un language...");
        mbuilder.setSingleChoiceItems(listItems, -1, (dialogInterface, i) -> {
            if(i==0){
                setLocale("fr");
                recreate();
            }
            if(i==1){
                setLocale("en");
                recreate();
            }
            if(i==2) {
                setLocale("de");
                recreate();
            }
            if(i==3) {
                setLocale("es");
                recreate();
            }


        });
        AlertDialog mDialog = mbuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale=new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting", MODE_PRIVATE).edit();
        editor.putString("Ma langue",lang);
        editor.apply();
    }
    public void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = preferences.getString("Ma langue", "");
        setLocale(language);
    }

}


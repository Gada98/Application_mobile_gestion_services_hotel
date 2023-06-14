package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.Objects;
/*inscription de client*/
public class inscrit_client extends AppCompatActivity {

    private Button regbtn;
    EditText txtNom, txtPrenom, txtNat, txtCin, txtAdd, txtTele, txtEmail, txtPasseport,txtArrive, txtDepart, txtPsd, txtMdp;
    String Nom, Prénom, Nationalité, N_CIN, Adresse, Téléphone, Email, N_passeport, Date_arrive, Date_départ, Login, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrit_client);




        regbtn=findViewById(R.id.regbtn);
        txtNom = findViewById(R.id.txtNom);
        txtPrenom = findViewById(R.id.txtPrenom);
        txtNat = findViewById(R.id.txtNat);
        txtCin = findViewById(R.id.txtCin);
        txtAdd = findViewById(R.id.txtAdd);
        txtTele = findViewById(R.id.txtTele);
        txtEmail = findViewById(R.id.txtEmail);
        txtPasseport = findViewById(R.id.txtPasseport);
        txtArrive = findViewById(R.id.txtArrive);
        txtDepart = findViewById(R.id.txtDepart);
        txtPsd = findViewById(R.id.txtPsd);
        txtMdp = findViewById(R.id.txtMdp);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Nom = txtNom.getText().toString();
                String Prénom = txtPrenom.getText().toString();
                String Nationalité = txtNat.getText().toString();
                String N_CIN = txtCin.getText().toString();
                String Adresse = txtAdd.getText().toString();
                String Téléphone = txtTele.getText().toString();
                String Email = txtEmail.getText().toString();
                String N_passeport = txtPrenom.getText().toString();
                String Date_arrive = txtArrive.getText().toString();
                String Date_départ = txtDepart.getText().toString();
                String Login = txtPsd.getText().toString();
                String Password = txtMdp.getText().toString();

                backgroundTask4 back = new backgroundTask4(getApplicationContext());
                back.execute(Nom, Prénom, Nationalité, N_CIN, Adresse, Téléphone, Email, N_passeport, Date_arrive, Date_départ, Login, Password);
                Enregistrer();
            }

        });
    }
    public void Enregistrer(){
        intialize();
        if(!validate()){
            Toast.makeText(this, "l'inscription a échoué",Toast.LENGTH_SHORT).show();
        }
        else {
            onSingupSuccess();
            Intent intent = new Intent(this, log_client.class);
            startActivity(intent);
        }
    }
    public void onSingupSuccess(){}
    public boolean validate() {
        boolean valid = true;
        if ((Nom.isEmpty())&(Nom.length()<30)) {
            txtNom.setError("\n" + "veuillez entrer un nom valide");
            valid = false;
        }
        if ((Prénom.isEmpty())&(Prénom.length()<30)) {
            txtPrenom.setError("\n" + "veuillez entrer un prenom valide");
            valid = false;
        }
        if ((Nationalité.isEmpty())&(Nationalité.length()<30)) {
            txtNat.setError("\n" + "veuillez entrer une nationalité valide");
            valid = false;
        }
        if (N_CIN.isEmpty()) {
            txtCin.setError("\n" + "veuillez entrer un numéro CIN valide");
            valid = false;
        }
        if ((Adresse.isEmpty())& (Adresse.length()<50)) {
            txtAdd.setError("\n" + "veuillez entrer une adresse valide");
            valid = false;
        }
        if (Téléphone.isEmpty()) {
            txtTele.setError("\n" + "veuillez entrer un numéro de téléphone valide");
            valid = false;
        }
        if ((Email.isEmpty())&(Email.length()<100)) {
            txtEmail.setError("\n" + "veuillez entrer un email valide");
            valid = false;
        }
        if (N_passeport.isEmpty()) {
            txtPasseport.setError("\n" + "veuillez entrer un numéro de passeport valide");
            valid = false;
        }
        if (Date_arrive.isEmpty()){
            txtArrive.setError("\n" + "veuillez entrer une date d'arrivé valide");
            valid = false;
        }
        if (Date_départ.isEmpty()){
            txtDepart.setError("\n" + "veuillez entrer une date de départ valide");
            valid = false;
        }
        if (Login.isEmpty()) {
            txtPsd.setError("\n" + "veuillez entrer un pseudo valide");
            valid = false;
        }
        if (Password.isEmpty()) {
            txtMdp.setError("\n" + "veuillez entrer une mot de passe valide");
            valid = false;
        }

        return valid;
    }
    public void intialize(){
        Nom = txtNom.getText().toString().trim();
        Prénom = txtPrenom.getText().toString().trim();
        Nationalité = txtNat.getText().toString().trim();
        N_CIN = txtCin.getText().toString().trim();
        Adresse = txtAdd.getText().toString().trim();
        Téléphone = txtTele.getText().toString().trim();
        Email = txtNom.getText().toString().trim();
        N_passeport = txtPasseport.getText().toString().trim();
        Date_arrive = txtArrive.getText().toString().trim();
        Date_départ = txtDepart.getText().toString().trim();
        Login = txtPsd.getText().toString().trim();
        Password = txtMdp.getText().toString().trim();
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"anglais", "allemand", "espagnol"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(inscrit_client.this);
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

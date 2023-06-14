package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.serviceshotel.utils.Receptionniste;
import com.example.serviceshotel.utils.SessionHandler1;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class profReceptionniste extends AppCompatActivity {
    private Button btn_reception;
    private EditText ed_nom, ed_add, ed_phone, ed_email;
    private SessionHandler1 sessionHandler1 ;

    public profReceptionniste(SessionHandler1 sessionHandler1) {
        this.sessionHandler1 = sessionHandler1;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_receptionniste);
        //Objects.requireNonNull(getSupportActionBar()).setTitle("profil_receptionniste");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_reception=findViewById(R.id.button);
        btn_reception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gérer();
            }
        });
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyDialog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());

        ed_nom = findViewById(R.id.ed_nom);
        ed_add = findViewById(R.id.ed_add);
        ed_phone = findViewById(R.id.ed_phone);
        ed_email = findViewById(R.id.ed_email);

        getDetails();
    }

    private void getDetails() {

        if (sessionHandler1.isLoggedIn()) {
            Receptionniste receptionniste = sessionHandler1.getDetails();

            String str = "";
            HttpResponse response;
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.43.175:8080/test/profilReceptionniste.php");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("pseudo", receptionniste.getPseudo()));
                nameValuePairs.add(new BasicNameValuePair("password", receptionniste.getPassword()));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                response = httpclient.execute(httppost);
                str = EntityUtils.toString(response.getEntity(), "UTF-8");

            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                JSONArray jsonArray = new JSONArray(str);
                JSONArray   array = jsonArray.optJSONArray(0) ;
                JSONObject json = array.getJSONObject(0) ;

                ed_nom.setText(json.getString("nom"));
                ed_add.setText(json.getString("adresse"));
                ed_phone.setText(json.getString("numéro_téléphone"));
                ed_email.setText(json.getString("email"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void Gérer(){
        Intent intent = new Intent(this, reception.class);
        startActivity(intent);
    }
}


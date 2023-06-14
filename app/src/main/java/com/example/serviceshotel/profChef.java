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

import com.example.serviceshotel.utils.Chef;
import com.example.serviceshotel.utils.SessionHandler2;

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
import java.util.Objects;

public class profChef extends AppCompatActivity {
    private Button btn_menu;
    private EditText ed_nom, ed_add, ed_phone, ed_email;
    private SessionHandler2 sessionHandler2 ;

    public profChef(SessionHandler2 sessionHandler2) {
        this.sessionHandler2 = sessionHandler2;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_chef);
        Objects.requireNonNull(getSupportActionBar()).setTitle("profil_chef");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_menu=findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gérer_menu();
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
        if (sessionHandler2.isLoggedIn()) {
            Chef chef_cuisinier = sessionHandler2.getDetails();
            String str = "";
            HttpResponse response;
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.43.175:8080/test/profilChef.php");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

                nameValuePairs.add(new BasicNameValuePair("pseudo", chef_cuisinier.getPseudo()));
                nameValuePairs.add(new BasicNameValuePair("password", chef_cuisinier.getPassword()));
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

    public void Gérer_menu(){
        Intent intent = new Intent(this, gerer_restaurant.class);
        startActivity(intent);
    }
}


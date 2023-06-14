package com.example.serviceshotel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import com.example.serviceshotel.utils.Gerant;
import com.example.serviceshotel.utils.SessionHandler3;

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

public class profGerant extends AppCompatActivity {
    private Button btn_gere;
    private EditText ed_nom, ed_add, ed_phone, ed_email;
    private SessionHandler3 sessionHandler3 ;

    public profGerant(SessionHandler3 sessionHandler3) {
        this.sessionHandler3 = sessionHandler3;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_gerant);
        Objects.requireNonNull(getSupportActionBar()).setTitle("profil_gerant");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_gere=findViewById(R.id.button);
        btn_gere.setOnClickListener(view -> Gérer());

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().penaltyDialog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());

        ed_nom = findViewById(R.id.ed_nom);
        ed_add = findViewById(R.id.ed_add);
        ed_phone = findViewById(R.id.ed_phone);
        ed_email = findViewById(R.id.ed_email);

        getDetails();
    }

    private void getDetails() {
        if (sessionHandler3.isLoggedIn()) {
            Gerant gérant = sessionHandler3.getDetails();

            String str = "";
            HttpResponse response;
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://192.168.43.175:8080/test/profilResponsable.php");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("pseudo", gérant.getPseudo()));
                nameValuePairs.add(new BasicNameValuePair("password", gérant.getPassword()));
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
        Intent intent = new Intent(this, gerer_personnelles.class);
        startActivity(intent);
    }
}


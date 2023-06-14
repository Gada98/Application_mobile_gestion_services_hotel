package com.example.serviceshotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class listChambre extends AppCompatActivity {
    String UrlServer="http://51.255.106.21/chambre.php";
    ProgressDialog progressDialog;
    ArrayList<HashMap<String, String>> listeCh = new ArrayList<>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chambre);
        lv = findViewById(R.id.ListView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listChambre.this, listeCh.get(i).get("matricule").toString() + " " + listeCh.get(i).get("type").toString() + " " + listeCh.get(i).get("nom_client").toString(),Toast.LENGTH_LONG).show();
            }
        });
        new Webservice().execute(UrlServer);
    }
    class Webservice extends AsyncTask<String, Void,String>{
        @Override
        protected void onPreExecute(){
            progressDialog = new ProgressDialog(listChambre.this);
            progressDialog.setMessage("connexion au serveur..");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... strings){
            StringBuilder result = new StringBuilder();
            try {
                HttpURLConnection conn;
                URL url = new URL(strings[0]);
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(1000);
                conn.connect();
                InputStream in = new BufferedInputStream(conn.getErrorStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null){
                    result.append(line);
                }
                conn.disconnect();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return result.toString();
        }
        @Override
        protected void onPostExecute(String JSON_Reponse){
            progressDialog.dismiss();
            JSONObject jsonObject = null;
            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(JSON_Reponse.toString());
                for (int x=0 ;x<jsonArray.length();x++){
                   jsonObject = jsonArray.getJSONObject(x);
                   String Matricule=jsonObject.getString("Matricule chambre");
                    String type=jsonObject.getString("type chambre");
                    String nom=jsonObject.getString("nom client");
                    HashMap<String,String> map =new HashMap<>();
                    map.put("matricule",Matricule);
                    map.put("type",type);
                    map.put("nom_client",nom);
                    listeCh.add(map);
                }
            }
            catch (JSONException e){
                Log.e("JSON Parser", "Error parsing data" + e.toString());
            }
            ListAdapter adapter = new SimpleAdapter(listChambre.this, listeCh,
                    R.layout.abc_search_view, new String[]{"matricule","type","nom_client"},
                    new int[] {R.id.Matricule, R.id.type, R.id.nom});
            lv.setAdapter(adapter);
        }
    }
}

package com.example.serviceshotel;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

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
import java.net.URLEncoder;

/*pour inscrit_chef*/
public class backgroundTask3 extends AsyncTask<String, String, String> {
    private final String chefURL= "http://192.168.43.175:8080/test/inscrit_chef.php";
    Context context;
    backgroundTask3(Context ctx){
        context=ctx;
    }
    @Override
    protected String doInBackground(String...strings) {

        String nom=strings[0];
        String prénom=strings[1];
        String nationalité=strings[2];
        String N_CIN=strings[3];
        String adresse=strings[4];
        String numéro_téléphone=strings[5];
        String email=strings[6];
        String Pseudo=strings[7];
        String Mot_de_passe=strings[8];

        try {
            URL url = new URL(chefURL);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String insert_data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(nom, "UTF-8") + "&"
                        + URLEncoder.encode("prénom", "UTF-8") + "=" + URLEncoder.encode(prénom, "UTF-8") + "&"
                        + URLEncoder.encode("nationalité", "UTF-8") + "=" + URLEncoder.encode(nationalité, "UTF-8") + "&"
                        + URLEncoder.encode("N_CIN", "UTF-8") + "=" + URLEncoder.encode(N_CIN, "UTF-8") + "&"
                        + URLEncoder.encode("adresse", "UTF-8") + "=" + URLEncoder.encode(adresse, "UTF-8") + "&"
                        + URLEncoder.encode("numéro_téléphone", "UTF-8") + "=" + URLEncoder.encode(numéro_téléphone, "UTF-8") + "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("Pseudo", "UTF-8") + "=" + URLEncoder.encode(Pseudo, "UTF-8") + "&"
                        + URLEncoder.encode("Mot_de_passe", "UTF-8") + "=" + URLEncoder.encode(Mot_de_passe, "UTF-8");
                bufferedWriter.write(insert_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                result = stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute (String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}

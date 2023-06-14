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

/*pour inscrit_client*/
public class backgroundTask4 extends AsyncTask<String, String, String> {
    Context context;
    backgroundTask4(Context ctx){
        this.context=ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String Nom=strings[0];
        String Prénom=strings[1];
        String Nationalité=strings[2];
        String N_CIN=strings[3];
        String Adresse=strings[4];
        String Téléphone=strings[5];
        String Email=strings[6];
        String N_passeport=strings[8];
        String Date_arrive=strings[9];
        String Date_départ=strings[10];
        String Login=strings[7];
        String Password=strings[8];
        String clientURL="http://localhost:8080/inscrit_client.php";

            try {
                URL url= new URL(clientURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("nom", "UTF-8") + "=" + URLEncoder.encode(Nom, "UTF-8") + "&"
                        + URLEncoder.encode("prenom", "UTF-8") + "=" + URLEncoder.encode(Prénom, "UTF-8")+ "&"
                        + URLEncoder.encode("nationalite", "UTF-8") + "=" + URLEncoder.encode(Nationalité, "UTF-8")+ "&"
                        + URLEncoder.encode("N_CIN", "UTF-8") + "=" + URLEncoder.encode(N_CIN, "UTF-8")+ "&"
                        + URLEncoder.encode("adresse", "UTF-8") + "=" + URLEncoder.encode(Adresse, "UTF-8")+ "&"
                        + URLEncoder.encode("numero_telephone", "UTF-8") + "=" + URLEncoder.encode(Téléphone, "UTF-8")+ "&"
                        + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(Email, "UTF-8")+ "&"
                        + URLEncoder.encode("N_passeport", "UTF-8") + "=" + URLEncoder.encode(N_passeport, "UTF-8")+ "&"+ URLEncoder.encode("Date_arrive", "UTF-8") + "=" + URLEncoder.encode(Date_arrive, "UTF-8")+
                        "&"+ URLEncoder.encode("Date_départ", "UTF-8") + "=" + URLEncoder.encode(Date_départ, "UTF-8")+"&"
                        + URLEncoder.encode("Login", "UTF-8") + "=" + URLEncoder.encode(Login, "UTF-8")+ "&"
                        + URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(Password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                StringBuilder stringBuilder= new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                result=stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
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


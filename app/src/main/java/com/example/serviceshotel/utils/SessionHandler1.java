package com.example.serviceshotel.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;
/*pour profil receptionniste*/
public class SessionHandler1 {
    private static final String PREF_NAME = "UserSession";
    private SharedPreferences.Editor mEditor;
    private static SharedPreferences mnPreferences;
    private static final String KEY_EMPTY = "";
    private static final String KEY_EXPIRES = "expires";

    public SessionHandler1( Context mContext) {
        mnPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mnPreferences.edit();
    }

    public  void LoginReceptionniste(Receptionniste receptionniste) {
        mEditor.putString("pseudo", receptionniste.getPseudo());
        mEditor.putString("password", receptionniste.getPassword());






        Date date = new Date();
        long millis = date.getTime() ;
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }
    public static boolean isLoggedIn() {


        long millis = mnPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */

        return millis!=0 ;
    }
    public static Receptionniste getDetails() {
        Receptionniste receptionniste = new  Receptionniste(
                mnPreferences.getString("pseudo",KEY_EMPTY),
                mnPreferences.getString("password",KEY_EMPTY)
        );
        return receptionniste ;
    }
}


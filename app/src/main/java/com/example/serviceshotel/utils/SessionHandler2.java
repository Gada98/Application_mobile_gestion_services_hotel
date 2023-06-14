package com.example.serviceshotel.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

/*pour profil chef*/
public class SessionHandler2 {
    private static final String PREF_NAME = "UserSession";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences nPreferences;
    private static final String KEY_EMPTY = "";
    private static final String KEY_EXPIRES = "expires";

    public SessionHandler2( Context mContext) {
        nPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = nPreferences.edit();
    }

    public  void LoginChef(Chef chef_cuisinier) {
        mEditor.putString("pseudo", chef_cuisinier.getPseudo());
        mEditor.putString("password", chef_cuisinier.getPassword());






        Date date = new Date();
        long millis = date.getTime() ;
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }
    public boolean isLoggedIn() {


        long millis = nPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */

        return millis!=0 ;
    }
    public Chef getDetails() {
        Chef chef_cuisinier = new Chef(
                nPreferences.getString("pseudo",KEY_EMPTY),
                nPreferences.getString("password",KEY_EMPTY)
        );
        return chef_cuisinier ;
    }
}


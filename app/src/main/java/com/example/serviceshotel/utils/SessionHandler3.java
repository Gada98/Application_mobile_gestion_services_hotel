package com.example.serviceshotel.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;
/*pour profil gerant*/
public class SessionHandler3 {
    private static final String PREF_NAME = "UserSession";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mpPreferences;
    private static final String KEY_EMPTY = "";
    private static final String KEY_EXPIRES = "expires";

    public SessionHandler3( Context mContext) {
        mpPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mpPreferences.edit();
    }

    public  void LoginGerant(Gerant gérant) {
        mEditor.putString("pseudo", gérant.getPseudo());
        mEditor.putString("password", gérant.getPassword());






        Date date = new Date();
        long millis = date.getTime() ;
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }
    public boolean isLoggedIn() {


        long millis = mpPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */

        return millis!=0 ;
    }
    public Gerant getDetails() {
        Gerant gérant = new  Gerant(
                mpPreferences.getString("pseudo",KEY_EMPTY),
                mpPreferences.getString("password",KEY_EMPTY)
        );
        return gérant ;
    }

}


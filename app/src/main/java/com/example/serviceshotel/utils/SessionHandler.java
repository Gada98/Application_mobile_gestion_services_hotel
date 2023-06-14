package com.example.serviceshotel.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;
/*pour profil responsable*/
public class SessionHandler {

    private static final String PREF_NAME = "UserSession";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;
    private static final String KEY_EMPTY = "";
    private static final String KEY_EXPIRES = "expires";

    public SessionHandler( Context mContext) {
        mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mPreferences.edit();
    }

    public  void LoginResponsable(Responsable responsable) {
        mEditor.putString("pseudo", responsable.getPseudo());
        mEditor.putString("password", responsable.getPassword());






        Date date = new Date();
        long millis = date.getTime() ;
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }
    public boolean isLoggedIn() {


        long millis = mPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */

        return millis!=0 ;
    }
    public Responsable getDetails() {
        Responsable responsable = new  Responsable(
                mPreferences.getString("pseudo",KEY_EMPTY),
                mPreferences.getString("password",KEY_EMPTY)
        );
        return responsable ;
    }

}

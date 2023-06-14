package com.example.serviceshotel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_NOM = "keynom";
    private static final String KEY_PRENOM = "keyprénom";
    private static final String KEY_NATIONALITE = "keynationalité";
    private static final String KEY_CIN = "keycin";
    private static final String KEY_ADRESSE = "keyadresse";
    private static final String KEY_TELEPHONE = "keytéléphone";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_PSEUDO = "keypseudo";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_ID = "keyid";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_NOM, user.getNom());
        editor.putString(KEY_PRENOM, user.getPrénom());
        editor.putString(KEY_NATIONALITE, user.getNationalité());
        editor.putString(KEY_CIN, user.getN_CIN());
        editor.putString(KEY_ADRESSE, user.getAdresse());
        editor.putString(KEY_TELEPHONE, user.getNuméro_téléphone());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_PSEUDO, user.getPseudo());
        editor.putString(KEY_PASSWORD, user.getMot_de_passe());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PSEUDO, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_NOM, null),
                sharedPreferences.getString(KEY_PSEUDO, null),
                sharedPreferences.getString(KEY_NATIONALITE, null),
                sharedPreferences.getString(KEY_CIN, null),
                sharedPreferences.getString(KEY_ADRESSE, null),
                sharedPreferences.getString(KEY_TELEPHONE, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PSEUDO, null),
                sharedPreferences.getString(KEY_PASSWORD, null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, log_chef.class));
    }
}

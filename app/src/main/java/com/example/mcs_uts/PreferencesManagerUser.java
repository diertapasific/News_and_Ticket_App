package com.example.mcs_uts;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManagerUser extends androidx.preference.PreferenceManager{
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_CONFIRM_PASSWORD = "confirmPassword";
    private static final String KEY_PHONE_NUMBER = "phoneNumber";

    public PreferencesManagerUser(Context context) {
        super(context);
    }

    public void PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setKeyUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public void setKeyEmail(String email) {
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public void setKeyPassword(String password) {
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public void setKeyConfirmPassword(String confirmPassword) {
        editor.putString(KEY_CONFIRM_PASSWORD, confirmPassword);
        editor.apply();
    }

    public void setKeyPhoneNumber(String phoneNumber) {
        editor.putString(KEY_PHONE_NUMBER, phoneNumber);
        editor.apply();
    }

    public String getKeyUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    public String getKeyEmail() {
        return sharedPreferences.getString(KEY_EMAIL, "");
    }

    public String getKeyPassword() {
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }

    public String getKeyConfirmPassword() {
        return sharedPreferences.getString(KEY_CONFIRM_PASSWORD, "");
    }

    public String getKeyPhoneNumber() {
        return sharedPreferences.getString(KEY_PHONE_NUMBER, "");
    }
}

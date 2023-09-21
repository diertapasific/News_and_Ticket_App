package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private PreferencesManagerUser preferenceManager;
    private SharedPreferences preferences, loginpref;
    private SharedPreferences.Editor editor;

    EditText email, password;
    Button buttonRegister, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_login_register);
        }

        buttonRegister = findViewById(R.id.buttonRegister_Login);
        buttonLogin = findViewById(R.id.buttonLogin_Login);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener((v) -> {

            String emails = email.getText().toString().trim();
            String passwords = password.getText().toString().trim();

            // Validation Email
            if(emails.isEmpty() && passwords.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "All fields must be filled.", Toast.LENGTH_LONG);
                toast.show();
            }  else if (!emails.endsWith(".com")) {
                Toast toast2 = Toast.makeText(LoginActivity.this, "Email must be ended by .com", Toast.LENGTH_LONG);
                toast2.show();
            } else if(emails.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "Please enter your email.", Toast.LENGTH_LONG);
                toast.show();
            } else if(passwords.isEmpty()){
                Toast toast = Toast.makeText(LoginActivity.this, "Please enter your password.", Toast.LENGTH_LONG);
                toast.show();
            }

            String savedEmail = preferences.getString("email", "");
            String savedPassword = preferences.getString("password", "");

            Log.d("email", savedEmail);
            Log.d("pass", savedPassword );

            if (emails.equals(savedEmail) && passwords.equals(savedPassword)){
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent);

                loginpref = getSharedPreferences("userlogin",MODE_PRIVATE);
                SharedPreferences.Editor loginedit = loginpref.edit();
                loginedit.putString("userlogin",emails);
                loginedit.apply();

                Toast toast = Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_LONG);
                toast.show();
            } else {
                // Login failed
                Toast toast = Toast.makeText(LoginActivity.this, "Your email address or password incorrect.", Toast.LENGTH_LONG);
                toast.show();
            }

        });

        buttonRegister.setOnClickListener((v) -> {
            // Navigate to another activity
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });


    }
}
package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private PreferencesManagerUser preferenceManager;
    EditText editTextName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextPhoneNumber;
    Button buttonRegister, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_login_register);
        }

        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        buttonRegister = findViewById(R.id.buttonRegister_Register);
        buttonLogin = findViewById(R.id.buttonLogin_Register);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);


        buttonRegister.setOnClickListener((v) -> {

            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            String confirmPassword = editTextConfirmPassword.getText().toString();
            String phoneNumber = editTextPhoneNumber.getText().toString();

            if(isValid()){
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", name);
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putString("confirmPassword", confirmPassword);
                editor.putString("phoneNumber", phoneNumber);
                editor.apply();

                Toast toast2 = Toast.makeText(RegisterActivity.this, "Account Created!", Toast.LENGTH_LONG);
                toast2.show();
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
            }
        });

        buttonLogin.setOnClickListener((e) -> {

            Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent2);
        });
    }

    private boolean isValid() {

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();

        Pattern patternPassword;
        Matcher matcherPassword;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{1,}$";
        patternPassword = Pattern.compile(PASSWORD_PATTERN);
        matcherPassword = patternPassword.matcher(password);

        // Check if userInput is valid
        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phoneNumber.isEmpty()){
            Toast toast = Toast.makeText(RegisterActivity.this, "All fields must be filled.", Toast.LENGTH_LONG);
            toast.show();
            return false;
        } else if(!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() && !phoneNumber.isEmpty()){
            if(name.length() < 5 ){
                Toast toast = Toast.makeText(RegisterActivity.this, "Full Name must be at least 5 characters long.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            } else if (!email.endsWith(".com")) {
                Toast toast2 = Toast.makeText(RegisterActivity.this, "Email must be ended by .com", Toast.LENGTH_LONG);
                toast2.show();
                return false;
            } else if(!matcherPassword.matches()){
                Toast toast = Toast.makeText(RegisterActivity.this, "Password must be alphanumeric & has capital letter.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            } else if(!confirmPassword.equals(password)){
                Toast toast = Toast.makeText(RegisterActivity.this, "Password does not match.", Toast.LENGTH_LONG);
                toast.show();
                return false;
            }
        }
        return true;
    }
}


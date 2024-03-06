package com.example.session10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView linkLogin;
    EditText emailField, usernameField, passwordField, confField;
    Button register;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailField = findViewById(R.id.et_email);
        usernameField = findViewById(R.id.et_username);
        passwordField = findViewById(R.id.et_password);
        confField = findViewById(R.id.et_conf);

        linkLogin = findViewById(R.id.tv_linklogin);
        register = findViewById(R.id.btn_register);

        linkLogin.setOnClickListener(v->{
            Intent loginIntent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(loginIntent);
        });

        sharedPreferences = getSharedPreferences("user_account", MODE_PRIVATE);

        register.setOnClickListener(v->{
            if (!emailField.getText().toString().contains("@")
                    || !emailField.getText().toString().contains(".com")){
                Toast.makeText(this, "Email must be valid and ends with .com", Toast.LENGTH_SHORT).show();
            } else if (usernameField.getText().toString().length() < 3){
                Toast.makeText(this, "Username must be more than 3 characters.", Toast.LENGTH_SHORT).show();
            } else if (passwordField.getText().toString().length() < 5){
                Toast.makeText(this, "Password must be more than 5 characters.", Toast.LENGTH_SHORT).show();
            } else if (!confField.getText().toString().equals(passwordField.getText().toString())) {
                Toast.makeText(this, "Password must be matched.", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email_user", emailField.getText().toString());
                editor.putString("password_user", passwordField.getText().toString());
                editor.putString("username_user", usernameField.getText().toString());
                editor.apply();

                // kasi notif buat user kalo misal registnya udah kelar
                Toast.makeText(this, "Registration Completed. Please login!", Toast.LENGTH_LONG).show();

                // abis pencet, pindah ke login page
                Intent toLogin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(toLogin);

                finish(); // ini biar ga balik lagi ke activity sebelumnya
            }
        });
    }
}
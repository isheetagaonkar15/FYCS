package com.farmerapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.farmerapp.R;
import com.farmerapp.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPrefManager = SharedPrefManager.getInstance(this);
        
        // Check if user is already logged in
        if (sharedPrefManager.isLoggedIn()) {
            startMainActivity();
            return;
        }

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
    }

    private void setupClickListeners() {
        buttonLogin.setOnClickListener(v -> {
            performLogin();
        });
    }

    private void performLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            return;
        }

        // TODO: Implement actual login logic with API call
        // For now, just simulate successful login
        sharedPrefManager.saveUserSession("1", "Farmer User", email);
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
        startMainActivity();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
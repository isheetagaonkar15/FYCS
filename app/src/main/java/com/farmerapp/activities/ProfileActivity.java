package com.farmerapp.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.farmerapp.R;
import com.farmerapp.utils.SharedPrefManager;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUserName;
    private TextView textViewUserEmail;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPrefManager = SharedPrefManager.getInstance(this);
        
        initViews();
        loadUserData();
    }

    private void initViews() {
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadUserData() {
        String userName = sharedPrefManager.getUserName();
        String userEmail = sharedPrefManager.getUserEmail();
        
        textViewUserName.setText(userName);
        textViewUserEmail.setText(userEmail);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
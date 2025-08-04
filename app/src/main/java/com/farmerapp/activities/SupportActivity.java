package com.farmerapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.farmerapp.R;

public class SupportActivity extends AppCompatActivity {

    private Button buttonCall;
    private Button buttonEmail;
    private Button buttonWhatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        initViews();
        setupClickListeners();
    }

    private void initViews() {
        buttonCall = findViewById(R.id.buttonCall);
        buttonEmail = findViewById(R.id.buttonEmail);
        buttonWhatsApp = findViewById(R.id.buttonWhatsApp);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Contact Support");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupClickListeners() {
        buttonCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+919876543210"));
            startActivity(intent);
        });

        buttonEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:support@farmerapp.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Farmer App Support");
            startActivity(Intent.createChooser(intent, "Send Email"));
        });

        buttonWhatsApp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/919876543210"));
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
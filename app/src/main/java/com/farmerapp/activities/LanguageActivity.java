package com.farmerapp.activities;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.farmerapp.R;
import com.farmerapp.utils.SharedPrefManager;

public class LanguageActivity extends AppCompatActivity {

    private RadioGroup radioGroupLanguage;
    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        sharedPrefManager = SharedPrefManager.getInstance(this);
        
        initViews();
        setupLanguageSelection();
    }

    private void initViews() {
        radioGroupLanguage = findViewById(R.id.radioGroupLanguage);
        
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Change Language");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupLanguageSelection() {
        String currentLanguage = sharedPrefManager.getLanguage();
        
        // Set current language selection
        if ("hi".equals(currentLanguage)) {
            radioGroupLanguage.check(R.id.radioHindi);
        } else if ("gu".equals(currentLanguage)) {
            radioGroupLanguage.check(R.id.radioGujarati);
        } else {
            radioGroupLanguage.check(R.id.radioEnglish);
        }

        radioGroupLanguage.setOnCheckedChangeListener((group, checkedId) -> {
            String selectedLanguage = "en"; // default to English
            
            if (checkedId == R.id.radioHindi) {
                selectedLanguage = "hi";
            } else if (checkedId == R.id.radioGujarati) {
                selectedLanguage = "gu";
            }
            
            sharedPrefManager.setLanguage(selectedLanguage);
            Toast.makeText(this, "Language changed successfully", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
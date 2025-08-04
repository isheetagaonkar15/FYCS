package com.farmerapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.farmerapp.R;
import com.farmerapp.activities.ProfileActivity;
import com.farmerapp.activities.LanguageActivity;
import com.farmerapp.activities.SupportActivity;
import com.farmerapp.activities.LoginActivity;
import com.farmerapp.utils.SharedPrefManager;

public class SettingsFragment extends Fragment {

    private LinearLayout buttonProfile;
    private LinearLayout buttonChangeLanguage;
    private LinearLayout buttonContactSupport;
    private LinearLayout buttonLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        
        initViews(view);
        setupClickListeners();
        
        return view;
    }

    private void initViews(View view) {
        buttonProfile = view.findViewById(R.id.buttonProfile);
        buttonChangeLanguage = view.findViewById(R.id.buttonChangeLanguage);
        buttonContactSupport = view.findViewById(R.id.buttonContactSupport);
        buttonLogout = view.findViewById(R.id.buttonLogout);
    }

    private void setupClickListeners() {
        // Profile button click listener
        buttonProfile.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        });

        // Language change button click listener
        buttonChangeLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LanguageActivity.class);
            startActivity(intent);
        });

        // Contact support button click listener
        buttonContactSupport.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SupportActivity.class);
            startActivity(intent);
        });

        // Logout button click listener
        buttonLogout.setOnClickListener(v -> {
            showLogoutConfirmationDialog();
        });
    }

    private void showLogoutConfirmationDialog() {
        new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    logout();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    private void logout() {
        // Clear user session
        SharedPrefManager.getInstance(requireContext()).clearUserSession();
        
        // Show logout message
        Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show();
        
        // Navigate to login activity
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
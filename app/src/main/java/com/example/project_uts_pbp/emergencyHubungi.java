package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class emergencyHubungi extends AppCompatActivity{

    private Button btnLokasiEmergency;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_emergency);
        setTitle("Emergency");
        btnLokasiEmergency = findViewById(R.id.btnLokasiEmergency);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//         bottomNavigationView.setSelectedItemId(R.id.homeMenu);
         bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        btnLokasiEmergency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(emergencyHubungi.this, emergencyGeolocation.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.homeMenu:
                            startActivity(new Intent(emergencyHubungi.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(emergencyHubungi.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };

}


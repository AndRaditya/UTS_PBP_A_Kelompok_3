 package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_uts_pbp.adapter.PendaftaranAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

 public class homeAplikasi extends AppCompatActivity {

    private ImageButton btnEmergency, btnDaftar,
            btnLayananDokter, btnJadwalAnda, btnProfilRumahSakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_aplikasi);

        btnEmergency = findViewById(R.id.btnEmergency);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnJadwalAnda = findViewById(R.id.btnJadwalAnda);
        btnLayananDokter = findViewById(R.id.btnLayananDokter);
        btnProfilRumahSakit = findViewById(R.id.btnProfilRumahSakit);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation); /*masih error*/
        bottomNavigationView.setSelectedItemId(R.id.homeMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        btnProfilRumahSakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeAplikasi.this, profilRS.class));
                finish();
            }
        });
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeAplikasi.this, InputDataPendaftaran.class));
                finish();
            }
        });
        btnJadwalAnda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeAplikasi.this, PendaftaranAdapter.class));
                finish();
            }
        });
//        btnLayananDokter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(homeAplikasi.this, profilRS.class));
//                finish();
//            }
//        });
        btnEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(homeAplikasi.this, emergencyHubungi.class));
                finish();
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item){
                    switch(item.getItemId()){
                        case R.id.homeMenu:
                            startActivity(new Intent(homeAplikasi.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(homeAplikasi.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };
}
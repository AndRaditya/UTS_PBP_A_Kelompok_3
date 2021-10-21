package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_uts_pbp.oneway.tampilDokterAnak;
import com.example.project_uts_pbp.oneway.tampilDokterMata;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class jadwalLayananUtama extends AppCompatActivity {
    private Button jadwalLayananAnak;
    private Button jadwalLayananMata;

     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_layanan_utama);
        jadwalLayananAnak = findViewById(R.id.jadwalLayananAnak);
        jadwalLayananMata = findViewById(R.id.jadwalLayananMata);
        setTitle("Jadwal Layanan Dokter");

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//         bottomNavigationView.setSelectedItemId(R.id.homeMenu);
         bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        jadwalLayananAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(jadwalLayananUtama.this, tampilDokterAnak.class));
            }
        });

        jadwalLayananMata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(jadwalLayananUtama.this, tampilDokterMata.class));
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.homeMenu:
                            startActivity(new Intent(jadwalLayananUtama.this, homeAplikasi.class));
                            finish();
                            break;
                        case R.id.profileMenu:
                            startActivity(new Intent(jadwalLayananUtama.this, profilePribadi.class));
                            finish();
                            break;
                    }
                    return true;
                }
            };
}

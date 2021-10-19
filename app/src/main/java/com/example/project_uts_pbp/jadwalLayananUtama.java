package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_uts_pbp.oneway.tampilDokterAnak;

public class jadwalLayananUtama extends AppCompatActivity {
    private Button jadwalLayananAnak;
    private Button jadwalLayananMata;

     @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_layanan_utama);
        jadwalLayananAnak = findViewById(R.id.jadwalLayananAnak);
        jadwalLayananMata = findViewById(R.id.jadwalLayananMata);

        jadwalLayananAnak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(jadwalLayananUtama.this, tampilDokterAnak.class));
            }
        });

        jadwalLayananMata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(jadwalLayananUtama.this, .class));
            }
        });
    }
}

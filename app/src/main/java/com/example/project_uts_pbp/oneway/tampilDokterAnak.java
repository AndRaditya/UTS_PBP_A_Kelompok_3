package com.example.project_uts_pbp.oneway;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.project_uts_pbp.R;
import com.example.project_uts_pbp.databinding.JadwalLayananDokterAnakBinding;

import java.util.ArrayList;

public class tampilDokterAnak extends AppCompatActivity {

    ArrayList<DokterAnak> DokterAnakList;
    JadwalLayananDokterAnakBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.jadwal_layanan_dokter_anak);
        setTitle("Jadwal Layanan Dokter Anak");
        DokterAnakList = new daftarDokterAnak().DokterAnak;
        binding.setDokter(DokterAnakList.get(0));

    }
}
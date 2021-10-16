package com.example.project_uts_pbp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.databinding.gd3_a_10168.R;
import com.databinding.gd3_a_10168.databinding.OneWayBinding;

import java.util.ArrayList;

import android.os.Bundle;


public class TampilPegawai extends AppCompatActivity {

    ArrayList<Dokter> DokterList;
    OneWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.jadwal_layanan);

        DokterList = new daftarDokter().Dokter;
        binding.setDokter(DokterList.get(3));

    }
}

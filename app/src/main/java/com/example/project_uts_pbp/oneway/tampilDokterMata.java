package com.example.project_uts_pbp.oneway;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.project_uts_pbp.R;
import com.example.project_uts_pbp.databinding.ActivityTampilDokterMataBinding;

import java.util.ArrayList;

public class tampilDokterMata extends AppCompatActivity {

    ArrayList<DokterMata> DokterMataList;
    ActivityTampilDokterMataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tampil_dokter_mata);
        setTitle("Jadwal Layanan Dokter Mata");
        DokterMataList = new daftarDokterMata().DokterMata;
        binding.setDokterMata(DokterMataList.get(0));
    }

}
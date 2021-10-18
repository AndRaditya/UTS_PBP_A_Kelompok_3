package com.example.project_uts_pbp.oneway;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class tampilDokterAnak extends AppCompatActivity {

    ArrayList<DokterAnak> DokterAnakList;
//    OneWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        binding = DataBindingUtil.setContentView(this, R.layout.jadwal_layanan);

        DokterAnakList = new daftarDokterAnak().DokterAnak;
//        binding.setdokter(DokterAnakList.get(2));

    }
}

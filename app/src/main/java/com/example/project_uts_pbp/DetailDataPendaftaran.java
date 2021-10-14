package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;

public class DetailDataPendaftaran extends AppCompatActivity{
    //deklarasi objek dan variabel
    Pegawai pgwi;
    TwoWayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.two_way);

        //Mengambil data dari intent
        String strPegawai = getIntent().getStringExtra("objPgw");
        Gson gson = new Gson();
        pgwi = gson.fromJson(strPegawai, Pegawai.class);

        //inisialisasi objek dan variabel ke data binding
        binding.setPgwi(pgwi);
        binding.setActivity(this);
    }

    //membuat response click listener yang akan digunakan pada button back
    public View.OnClickListener btnBackClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Intent mainActivity = new Intent(DetailDataPegawai.this, InputDataPegawai.class);
            mainActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }

    };

}



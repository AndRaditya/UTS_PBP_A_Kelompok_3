package com.example.project_uts_pbp;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uts_pbp.Adapter.PendaftaranAdapter;
import com.example.project_uts_pbp.Model.Pendaftaran;
import com.example.project_uts_pbp.Database.DatabasePendaftaran;

import java.util.ArrayList;
import java.util.List;

public class InputDataPendaftaran extends AppCompatActivity {
    private EditText namaPendaftaran, tanggalLahir, nomorHp,
            tanggalPeriksa, keluhan, jenisKelamin, kategoriPenyakit;
    private Button btnDaftarOnline;
    private RecyclerView rv_JadwalAnda;

    private List<Pendaftaran> pendaftaranList;
    private PendaftaranAdapter pendaftaranAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);

        rv_JadwalAnda = findViewById(R.id.rv_JadwalAnda);
        namaPendaftaran = findViewById(R.id.namaPendaftaran);
        tanggalLahir = findViewById(R.id.tanggalLahir);
        nomorHp = findViewById(R.id.nomorHp);
        tanggalPeriksa = findViewById(R.id.tanggalperiksa);
        keluhan = findViewById(R.id.keluhan);
        jenisKelamin = findViewById(R.id.jenisKelamin);
        kategoriPenyakit = findViewById(R.id.kategoriPenyakit);
        btnDaftarOnline = findViewById(R.id.btnDaftarOnline);

        btnDaftarOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!namaPendaftaran.getText().toString().isEmpty() && !tanggalLahir.getText().toString().isEmpty()
                     && !nomorHp.getText().toString().isEmpty() && !tanggalPeriksa.getText().toString().isEmpty()
                     && !keluhan.getText().toString().isEmpty() && !jenisKelamin.getText().toString().isEmpty()
                     && !kategoriPenyakit.getText().toString().isEmpty()){
                    addPendaftaran();
                }
                else{
                    Toast.makeText(InputDataPendaftaran.this, "Belum diisi tuh", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getPendaftaran();
        pendaftaranList = new ArrayList<>();
    }

    private void addPendaftaran(){
        final String namaPendaftar = namaPendaftaran.getText().toString();
        final String tanggalLahirPendaftar = tanggalLahir.getText().toString();
        final String nomorHpPendaftar = nomorHp.getText().toString();
        final String tanggalPeriksaPendaftar = tanggalPeriksa.getText().toString();
        final String jenisKelaminPendaftar = jenisKelamin.getText().toString();
        final String keluhanPendaftar = keluhan.getText().toString();
        final String kategoriPendaftar = kategoriPenyakit.getText().toString();

        class AddTodo extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids){
                Pendaftaran pendaftaran = new Pendaftaran();
                pendaftaran.setNamaPendaftar(namaPendaftar);
                pendaftaran.setTanggalLahirPendaftar(tanggalLahirPendaftar);
                pendaftaran.setNomorHpPendaftar(nomorHpPendaftar);
                pendaftaran.setTanggalPeriksaPendaftar(tanggalPeriksaPendaftar);
                pendaftaran.setJenisKelaminPendaftar(jenisKelaminPendaftar);
                pendaftaran.setKeluhanPendaftar(keluhanPendaftar);
                pendaftaran.setKategoriPenyakitPendaftar(kategoriPendaftar);

                DatabasePendaftaran.getInstance(getApplicationContext())
                        .getDatabase()
                        .pendaftaranDao()
                        .insertTodo(pendaftaran);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused){
                super.onPostExecute(unused);
                Toast.makeText(InputDataPendaftaran.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                getPendaftaran();
            }
        }
        AddTodo addTodo = new AddTodo( );
        addTodo.execute();
    }

    private void getPendaftaran(){
        class GetPendaftaran extends AsyncTask<Void, Void, List<Pendaftaran>>{
            @Override
            protected List<Pendaftaran> doInBackground(Void... voids){
                List<Pendaftaran> pendaftaranList = DatabasePendaftaran.getInstance(getApplicationContext())
                        .getDatabase()
                        .pendaftaranDao()
                        .getAll();
                return pendaftaranList;
            }
            @Override
            protected void onPostExecute(List<Pendaftaran> pendaftarans){
                super.onPostExecute(pendaftarans);
                pendaftaranAdapter = new PendaftaranAdapter(pendaftarans, InputDataPendaftaran.this);
                rv_JadwalAnda.setAdapter(pendaftaranAdapter);
            }
        }
        GetPendaftaran getPendaftarans = new GetPendaftaran();
        getPendaftarans.execute();
    }
}

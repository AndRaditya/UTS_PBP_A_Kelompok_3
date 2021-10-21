package com.example.project_uts_pbp;
import static com.example.project_uts_pbp.myApplication.CHANNEL_1_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uts_pbp.adapter.PendaftaranAdapter;
import com.example.project_uts_pbp.database.DatabasePendaftaran;
import com.example.project_uts_pbp.model.Pendaftaran;

import java.util.List;

public class InputDataPendaftaran extends AppCompatActivity {
    private EditText namaPendaftaran, tanggalLahir, nomorHp,
            tanggalPeriksa, keluhan, jenisKelamin, kategoriPenyakit;
    private Button btnDaftarOnline, btnKembali;
    private RecyclerView rv_JadwalAnda;
    private NotificationManagerCompat notificationManager;

    private List<Pendaftaran> pendaftaranList;
    private PendaftaranAdapter pendaftaranAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);
        setTitle("Pendaftaran");

        notificationManager = NotificationManagerCompat.from(this);

        rv_JadwalAnda = findViewById(R.id.rv_JadwalAnda);
        namaPendaftaran = findViewById(R.id.namaPendaftaran);
        tanggalLahir = findViewById(R.id.tanggalLahir);
        nomorHp = findViewById(R.id.nomorHp);
        tanggalPeriksa = findViewById(R.id.tanggalperiksa);
        keluhan = findViewById(R.id.keluhan);
        jenisKelamin = findViewById(R.id.jenisKelamin);
        kategoriPenyakit = findViewById(R.id.kategoriPenyakit);
        btnDaftarOnline = findViewById(R.id.btnDaftarOnline);
        btnKembali = findViewById(R.id.btnKembali);

        btnDaftarOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!namaPendaftaran.getText().toString().isEmpty() && !tanggalLahir.getText().toString().isEmpty()
                     && !nomorHp.getText().toString().isEmpty() && !tanggalPeriksa.getText().toString().isEmpty()
                     && !keluhan.getText().toString().isEmpty() && !jenisKelamin.getText().toString().isEmpty()
                     && !kategoriPenyakit.getText().toString().isEmpty()){
                    addPendaftaran();
                    sendOnChannel1(view);
                }
                else{
                    Toast.makeText(InputDataPendaftaran.this, "Belum diisi tuh", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputDataPendaftaran.this, homeAplikasi.class));
                finish();
            }
        });
//        pendaftaranList = new ArrayList<>();
//        getPendaftaran();
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
//                getPendaftaran();
            }
        }
        AddTodo addTodo = new AddTodo( );
        addTodo.execute();
    }

//    private void getPendaftaran(){
//        class GetPendaftaran extends AsyncTask<Void, Void, List<Pendaftaran>>{
//            @Override
//            protected List<Pendaftaran> doInBackground(Void... voids){
//                List<Pendaftaran> pendaftaranList = DatabasePendaftaran.getInstance(getApplicationContext())
//                        .getDatabase()
//                        .pendaftaranDao()
//                        .getAll();
//                return pendaftaranList;
//            }
//            @Override
//            protected void onPostExecute(List<Pendaftaran> pendaftarans){
//                super.onPostExecute(pendaftarans);
//                pendaftaranAdapter = new PendaftaranAdapter(pendaftarans, InputDataPendaftaran.this);
//                rv_JadwalAnda.setAdapter(pendaftaranAdapter);
//            }
//        }
//        GetPendaftaran getPendaftarans = new GetPendaftaran();
//        getPendaftarans.execute();
//    }

    public void sendOnChannel1(View view){
        String message = namaPendaftaran.getText().toString();

        Intent activityIntent = new Intent(this, InputDataPendaftaran.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, notificationReceiver.class);
        broadcastIntent.putExtra("toastMessage",message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this, 0, broadcastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
//            .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
            .setContentTitle("Pendaftaran Anda Telah Berhasil")
            .setContentText(message + " telah terdaftar")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .setColor(Color.BLUE)
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setOnlyAlertOnce(true)
            .addAction(R.mipmap.ic_launcher, "Toast", actionIntent)
            .build();
        
        notificationManager.notify(1,notification);
    }
}
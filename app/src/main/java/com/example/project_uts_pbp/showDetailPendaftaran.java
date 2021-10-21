package com.example.project_uts_pbp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uts_pbp.adapter.PendaftaranAdapter;
import com.example.project_uts_pbp.database.DatabasePendaftaran;
import com.example.project_uts_pbp.model.Pendaftaran;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class showDetailPendaftaran extends AppCompatActivity {

    private RecyclerView rv_JadwalAnda;
    private List<Pendaftaran> pendaftaranList;
    private PendaftaranAdapter pendaftaranAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_pendaftaran);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation); /*masih error*/
//        bottomNavigationView.setSelectedItemId(R.id.homeMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        rv_JadwalAnda = findViewById(R.id.rv_JadwalAnda);
        rv_JadwalAnda.setLayoutManager(new LinearLayoutManager(this));
        setTitle("Jadwal Pendaftaran Anda");
        getPendaftaran();
        pendaftaranList = new ArrayList<>();
    }

    private void getPendaftaran(){
        class GetTodos extends AsyncTask<Void, Void, List<Pendaftaran>> {
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
                pendaftaranAdapter = new PendaftaranAdapter(pendaftarans, showDetailPendaftaran.this);
                rv_JadwalAnda.setAdapter(pendaftaranAdapter);
            }
        }

        GetTodos getTodos = new GetTodos();
        getTodos.execute();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.homeMenu:
                        startActivity(new Intent(showDetailPendaftaran.this, homeAplikasi.class));
                        finish();
                        break;
                    case R.id.profileMenu:
                        startActivity(new Intent(showDetailPendaftaran.this, profilePribadi.class));
                        finish();
                        break;
                }
                return true;
            }
        };

}
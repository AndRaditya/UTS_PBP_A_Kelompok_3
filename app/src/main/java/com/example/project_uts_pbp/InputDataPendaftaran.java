package com.example.project_uts_pbp;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_uts_pbp.model.Pendaftaran;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class InputDataPendaftaran extends AppCompatActivity {
    private EditText namaPendaftaran, tanggalLahir, nomorHp, tanggalPeriksa, keluhan, jenisKelamin, dokter;
    private Button btnDaftarOnline;

    private List<Pendaftaran> pendaftaranList;
//    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);

        namaPendaftaran = findViewById(R.id.namaPendaftaran);
        tanggalLahir = findViewById(R.id.tanggalLahir);
        nomorHp = findViewById(R.id.nomorHp);
        tanggalPeriksa = findViewById(R.id.tanggalperiksa);
        keluhan = findViewById(R.id.keluhan);
        jenisKelamin = findViewById(R.id.jenisKelamin);
        dokter = findViewById(R.id.dokter);
        btnDaftarOnline = findViewById(R.id.btnDaftarOnline);

        btnDaftarOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!namaPendaftaran.getText().toString().isEmpty() && !tanggalLahir.getText().toString().isEmpty()
                     && !nomorHp.getText().toString().isEmpty() && !tanggalPeriksa.getText().toString().isEmpty()
                     && !keluhan.getText().toString().isEmpty() && !jenisKelamin.getText().toString().isEmpty()
                     && !dokter.getText().toString().isEmpty()){
                    addPendaftaran();
                }
                else{
                    Toast.makeText(InputDataPendaftaran.this, "Belum diisi tuh", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getTodos();
        pendaftaranList = new ArrayList<>();
    }

    private void addPendaftaran(){
        final String namaPendaftar = namaPendaftaran.getText().toString();

        class AddTodo extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids){
                Todo todo = new Todo();
                todo.setTitle(namaPendaftar);

                DatabaseTodo.getInstance(getApplicationContext())
                        .getDatabase()
                        .todoDao()
                        .insertTodo(todo);
                return null;
            }

            @Override
            protected void onPostExecute(Void unused){
                super.onPostExecute(unused);
                Toast.makeText(MainActivityTodoList.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                edt_todo.setText("");
                getTodos();
            }
        }
        AddTodo addTodo = new AddTodo( );
        addTodo.execute();
    }


}

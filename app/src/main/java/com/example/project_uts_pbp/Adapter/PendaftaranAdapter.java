package com.example.project_uts_pbp.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_uts_pbp.Model.Pendaftaran;
import com.example.project_uts_pbp.R;
import com.google.gson.Gson;

import java.util.List;

public class PendaftaranAdapter extends RecyclerView.Adapter<PendaftaranAdapter.ViewHolder>{

    private List<Pendaftaran> pendaftaranList;
    private Context context;


    public PendaftaranAdapter(List<Pendaftaran> todoList, Context context){
        this.pendaftaranList = pendaftaranList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jadwal_anda_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pendaftaran pendaftaran = pendaftaranList.get(position);
        holder.txtKategoriPenyakit.setText(pendaftaran.getKategoriPenyakitPendaftar());
        holder.textTanggalJadwalAnda.setText(pendaftaran.getTanggalPeriksaPendaftar());
        holder.textKeluhanJadwalAnda.setText(pendaftaran.getKeluhanPendaftar());
    }

    @Override
    public int getItemCount() {
        return pendaftaranList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKategoriPenyakit,
                textTanggalJadwalAnda, textKeluhanJadwalAnda;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtKategoriPenyakit = itemView.findViewById(R.id.txtKategoriPenyakit);
            textTanggalJadwalAnda = itemView.findViewById(R.id.textTanggalJadwalAnda);
            textKeluhanJadwalAnda = itemView.findViewById(R.id.textKeluhanJadwalAnda);
        }
    }
}



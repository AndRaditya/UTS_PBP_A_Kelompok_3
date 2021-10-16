package com.example.project_uts_pbp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.example.project_uts_pbp.BR;

public class Pendaftaran {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "namaPendaftar")
    private String namaPendaftar;

    @ColumnInfo(name = "tanggalLahirPendaftar")
    private String tanggalLahirPendaftar;

    @ColumnInfo(name = "nomorHpPendaftar")
    private String nomorHpPendaftar;

    @ColumnInfo(name = "tanggalPeriksaPendaftar")
    private String tanggalPeriksaPendaftar;

    @ColumnInfo(name = "jenisKelaminPendaftar")
    private String jenisKelaminPendaftar;

    @ColumnInfo(name = "keluhanPendaftar")
    private String keluhanPendaftar;

    @ColumnInfo(name = "dokterPendaftar")
    private String dokterPendaftar;


}

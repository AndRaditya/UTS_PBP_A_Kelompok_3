package com.example.project_uts_pbp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pendaftaran")
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

    @ColumnInfo(name = "kategoriPenyakitPendaftar")
    private String kategoriPenyakitPendaftar;


    public String getNamaPendaftar() {
        return namaPendaftar;
    }

    public void setNamaPendaftar(String namaPendaftar) {
        this.namaPendaftar = namaPendaftar;
    }

    public String getTanggalLahirPendaftar() {
        return tanggalLahirPendaftar;
    }

    public void setTanggalLahirPendaftar(String tanggalLahirPendaftar) {
        this.tanggalLahirPendaftar = tanggalLahirPendaftar;
    }

    public String getNomorHpPendaftar() {
        return nomorHpPendaftar;
    }

    public void setNomorHpPendaftar(String nomorHpPendaftar) {
        this.nomorHpPendaftar = nomorHpPendaftar;
    }

    public String getTanggalPeriksaPendaftar() {
        return tanggalPeriksaPendaftar;
    }

    public void setTanggalPeriksaPendaftar(String tanggalPeriksaPendaftar) {
        this.tanggalPeriksaPendaftar = tanggalPeriksaPendaftar;
    }

    public String getJenisKelaminPendaftar() {
        return jenisKelaminPendaftar;
    }

    public void setJenisKelaminPendaftar(String jenisKelaminPendaftar) {
        this.jenisKelaminPendaftar = jenisKelaminPendaftar;
    }

    public String getKeluhanPendaftar() {
        return keluhanPendaftar;
    }

    public void setKeluhanPendaftar(String keluhanPendaftar) {
        this.keluhanPendaftar = keluhanPendaftar;
    }

    public String getKategoriPenyakitPendaftar() {
        return kategoriPenyakitPendaftar;
    }

    public void setKategoriPenyakitPendaftar(String kategoriPenyakitPendaftar) {
        this.kategoriPenyakitPendaftar = kategoriPenyakitPendaftar;
    }
}

package com.example.project_uts_pbp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class User {
    private String email;
    private String password;
//    private String nomor_telepon;
//    private String nama;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
//        this.nomor_telepon = nomor_telepon;
//        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    String nomor_telepon, String nama
//    public String getNomor_telepon() {
//        return nomor_telepon;
//    }
//
//    public void setNomor_telepon(String nomor_telepon) {
//        this.nomor_telepon = nomor_telepon;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }

}
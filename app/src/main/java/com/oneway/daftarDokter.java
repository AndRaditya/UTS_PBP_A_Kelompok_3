package com.example.project_uts_pbp;

import java.util.ArrayList;

public class daftarDokter {
    public ArrayList<Dokter> Dokter;
    public daftarDokter(){

        Dokter = new ArrayList();
        Dokter.add(Noor);
        Dokter.add(Abigail);

        
    }

    public static final Pegawai Yosia = new Pegawai("El Sabah Noor","180709971","Asisten Bahasa Inggris Khusus","Yogyakarta",5000000,2018);

    public static final Pegawai Wendy = new Pegawai("Wendy Winata","180709598","Asisten Dasar Pemrograman","Kaliurang",5500000,2017);

    




}
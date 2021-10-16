package com.example.project_uts_pbp;

import java.util.ArrayList;

public class daftarDokter {
    public ArrayList<Dokter> Dokter;
    public daftarDokter(){

        Dokter = new ArrayList();
        Dokter.add(Noor);
        Dokter.add(Abigail);

        
    }

    public static final Pegawai Noor = new Pegawai("En Sabah Noor","Anak","19.30 - 20.30 "," 18.30 - 21.30", "-", "-", "- ", "-", "-", "Malam");

    public static final Pegawai Abigail = new Pegawai("Abigail De Caprio","Anak","12.30 - 20.30 "," 13.30 - 21.30", "-", "-", "- ", "-", "-", "Siang");
    




}
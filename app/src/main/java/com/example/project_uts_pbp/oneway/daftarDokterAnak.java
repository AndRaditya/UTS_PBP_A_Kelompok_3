package com.example.project_uts_pbp.oneway;

import java.util.ArrayList;

public class daftarDokterAnak {
    public ArrayList<DokterAnak> DokterAnak;
    public daftarDokterAnak(){

        DokterAnak = new ArrayList();
        DokterAnak.add(Noor);
        DokterAnak.add(Abigail);
    }

    public static final DokterAnak Noor = new DokterAnak("En Sabah Noor","Anak","19.30 - 20.30 "," 18.30 - 21.30", "-", "-", "- ", "-", "-", "Malam");
    public static final DokterAnak Abigail = new DokterAnak("Abigail De Caprio","Anak","12.30 - 20.30 "," 13.30 - 21.30", "-", "-", "- ", "-", "-", "Siang");
}
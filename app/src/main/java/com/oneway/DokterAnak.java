package com.example.project_uts_pbp;

public class Dokter    {

    public String namadokter;
    public String poliklinik;
    public String minggu;
    public String senin;
    public String selasa;
    public String rabu;
    public String kamis;
    public String jumat;
    public String sabtu;
    public String shift;


    public Pegawai(String namadokter, String poliklinik, String minggu, String senin, String selasa, String rabu, String kamis, String jumat,
                    String sabtu, String shift)

    {   
        this.namadokter = namadokter;
        this.poliklinik = poliklinik;
        this.minggu = minggu;
        this.senin = senin;
        this.selasa = selasa;
        this.rabu = rabu;
        this.kamis = kamis;
        this.jumat = jumat;
        this.sabtu = sabtu;
        this.shift = shift;

    }

    public String getNamadokter()  {return namadokter; }

    public void setNamadokter(String namadokter) { this.namadokter= namadokter; }

    public String getPoliklinik()  {return poliklinik; }

    public void setPoliklinik(String poliklinik) { this.poliklinik= poliklinik; }

    public String getMinggu()  {return minggu; }

    public void setMinggu(String minggu) { this.minggu= minggu; }

    public String getSenin()  {return senin; }

    public void setSenin(String senin) { this.senin= senin; }

    public String getSelasa()  {return selasa; }

    public void setSelasa(String selasa) { this.selasa=selasa; }

    public String getRabu()  {return rabu; }

    public void setRabu(String rabu) { this.rabu= rabu; }

    public String getKamis()  {return kamis; }

    public void setKamis(String kamis) { this.kamis= kamis; }

    public String getJumat()  {return jumat; }

    public void setJumat(String jumat) { this.jumat= jumat; }

    public String getSabtu()  {return sabtu; }

    public void setSabtu(String sabtu) { this.sabtu= sabtu; }

    public String getShift()  {return shift; }

    public void setShift(String shift) { this.shift= shift; }

    



}
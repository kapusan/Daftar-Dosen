package com.rackspira.dos_a.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Anang S on 23/04/2018.
 */

public class ListJadwal {
    @SerializedName("semester")
    @Expose
    private String semester;

    @SerializedName("nama_dosen")
    @Expose
    private String namaDosen;

    @SerializedName ("nama_makul")
    @Expose
    private String namaMakul;

    @SerializedName("kelas")
    @Expose
    private String kelas;

    @SerializedName("sks")
    @Expose
    private String sks;

    @SerializedName("hari")
    @Expose
    private String hari;

    @SerializedName("jam_mulai")
    @Expose
    private String jamMulai;

    @SerializedName("jam_selesai")
    @Expose
    private String jamSelesai;

    @SerializedName("ruang")
    @Expose
    private String ruang;


    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getNamaMakul() {
        return namaMakul;
    }

    public void setNamaMakul(String namaMakul) {
        this.namaMakul = namaMakul;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }


}

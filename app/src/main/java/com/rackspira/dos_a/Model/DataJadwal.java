package com.rackspira.dos_a.Model;

import java.util.List;

/**
 * Created by Anang S on 23/04/2018.
 */

public class DataJadwal {
    private String jumlah_jadwal;
    private List<ListJadwal> dataJadwal;

    public String getJumlah_jadwal() {
        return jumlah_jadwal;
    }

    public void setJumlah_jadwal(String jumlah_jadwal) {
        this.jumlah_jadwal = jumlah_jadwal;
    }

    public List<ListJadwal> getDataJadwal() {
        return dataJadwal;
    }

    public void setDataJadwal(List<ListJadwal> dataJadwal) {
        this.dataJadwal = dataJadwal;
    }
}

package com.rackspira.dos_a.Model;

import java.util.List;

/**
 * Created by Anang S on 23/04/2018.
 */

public class DataNamaDosen {
    private String jumlah_dosen;
    private List<ListDosen> dataDosen;

    public String getJumlah_dosen() {
        return jumlah_dosen;
    }

    public void setJumlah_dosen(String jumlah_dosen) {
        this.jumlah_dosen = jumlah_dosen;
    }

    public List<ListDosen> getDataDosen() {
        return dataDosen;
    }

    public void setDataDosen(List<ListDosen> dataDosen) {
        this.dataDosen = dataDosen;
    }
}

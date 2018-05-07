package com.rackspira.dos_a.Model;

import java.util.List;

public class DataMatkul {

    private String jumlah_makul;
    private List<ListMakul> dataMakul;

    public String getJumlah_makul() {
        return jumlah_makul;
    }

    public void setJumlah_makul(String jumlah_makul) {
        this.jumlah_makul = jumlah_makul;
    }

    public List<ListMakul> getDataMakul() {
        return dataMakul;
    }

    public void setDataMakul(List<ListMakul> dataMakul) {
        this.dataMakul = dataMakul;
    }
}

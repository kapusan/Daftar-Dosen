package com.rackspira.dos_a.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Anang S on 23/04/2018.
 */

public class Data {

    @SerializedName("dataJadwal")
    @Expose
    private ArrayList<ListJadwal> listJadwals;

    public ArrayList<ListJadwal> getListJadwals() {
        return listJadwals;
    }

    public void setListJadwals(ArrayList<ListJadwal> listJadwals) {
        this.listJadwals = listJadwals;
    }
}

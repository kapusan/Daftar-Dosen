package com.rackspira.dos_a.network;

import android.support.v7.widget.CardView;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataJadwal;
import com.rackspira.dos_a.Model.DataMatkul;
import com.rackspira.dos_a.Model.DataNamaDosen;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anang S on 09/04/2018.
 */

public interface GetDataService {
    @GET("makul")
    Call<BaseResponse<DataMatkul>> getJadwalMatkul();

    @GET("dosen")
    Call<BaseResponse<DataNamaDosen>> getJadwalDosen();

    @GET("jadwal_by_dosen")
    Call<BaseResponse<DataJadwal>> getDetailDosen(@Query("nama_dosen") String dosen);

    @GET("jadwal_by_makul")
    Call<BaseResponse<DataJadwal>> getDetailMakul(@Query("makul") String makul);

}

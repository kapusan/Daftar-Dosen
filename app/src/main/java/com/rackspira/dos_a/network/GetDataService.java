package com.rackspira.dos_a.network;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.Data;
import com.rackspira.dos_a.Model.DataJadwal;
import com.rackspira.dos_a.Model.ListJadwal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Anang S on 09/04/2018.
 */

public interface GetDataService {
    @GET("jadwal")
    Call<Data> getData();

    @GET("jadwal_by_dosen")
    Call<BaseResponse<DataJadwal>> getJadwalDosen(@Query("nama_dosen") String nama_dosen);

}

package com.rackspira.dos_a.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.Data;
import com.rackspira.dos_a.Model.DataJadwal;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by iTPix on 4/4/2018.
 */

public class DosenFragment extends android.support.v4.app.Fragment{

    private RecyclerView recyclerView;

    public DosenFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_fragment_dosen);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        getJadwalDosen("A. Budi Sugiharjo, S.E., M.M");

        return view;
    }

    private void getJadwalDosen(String namaDosen) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataJadwal>> call = service.getJadwalDosen(namaDosen);
        call.enqueue(new Callback<BaseResponse<DataJadwal>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataJadwal>> call, Response<BaseResponse<DataJadwal>> response) {
                if (response.isSuccessful()){
                    if (response.isSuccessful()){
                        DosenList adapter = new DosenList(getContext(),response.body().getData().getDataJadwal());
                        recyclerView.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DataJadwal>> call, Throwable t) {

            }
        });
    }
}

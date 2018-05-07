package com.rackspira.dos_a.fragment;


import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataNamaDosen;
import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;
import com.rackspira.dos_a.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by iTPix on 4/4/2018.
 */

public class DosenFragment extends android.support.v4.app.Fragment{

    private RecyclerView recyclerView;
    private SearchView searchView;
    private DosenList adapter;

    public DosenFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_dosen);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getJadwalDosen();

        whiteNotificationBar(recyclerView);

        return view;
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getActivity().getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    private void getJadwalDosen() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataNamaDosen>> call = service.getJadwalDosen();
        call.enqueue(new Callback<BaseResponse<DataNamaDosen>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataNamaDosen>> call, Response<BaseResponse<DataNamaDosen>> response) {
                if (response.isSuccessful()) {
                    adapter = new DosenList(getContext(), response.body().getData().getDataDosen());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<BaseResponse<DataNamaDosen>> call, Throwable t) {

            }
        });
    }

}

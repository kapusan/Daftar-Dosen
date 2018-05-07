package com.rackspira.dos_a.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataMatkul;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.MatkulList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by iTPix on 4/4/2018.
 */

public class MatkulFragment extends android.support.v4.app.Fragment {

    private AppCompatSpinner spinnerSemester;
    private RecyclerView recyclerView;
    private MatkulList adapter;

    public MatkulFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_matkul, container, false);

        spinnerSemester = (AppCompatSpinner) view.findViewById(R.id.spinner_semester);
        ArrayAdapter<CharSequence> spinneAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.pilihan,
                R.layout.support_simple_spinner_dropdown_item
        );
        spinnerSemester.setAdapter(spinneAdapter);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_matkul);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getMatkul();

        return view;
    }

    private void getMatkul() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataMatkul>> call = service.getJadwalMatkul();
         call.enqueue(new Callback<BaseResponse<DataMatkul>>() {
             @Override
             public void onResponse(Call<BaseResponse<DataMatkul>> call, Response<BaseResponse<DataMatkul>> response) {
                 if (response.isSuccessful()){
                     MatkulList adapter = new MatkulList(getContext(), response.body().getData().getDataMakul());
                     recyclerView.setAdapter(adapter);
                 }
             }

             @Override
             public void onFailure(Call<BaseResponse<DataMatkul>> call, Throwable t) {

             }
         });
    }


}

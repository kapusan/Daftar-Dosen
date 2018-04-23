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
import android.widget.Toast;

import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.MatkulList;
import com.rackspira.dos_a.Model.Data;
import com.rackspira.dos_a.Model.ListJadwal;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import java.util.List;

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

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_matkul);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
//        loadJSON();
    }

    private void loadJSON() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Data> call = service.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data = response.body();
                List<ListJadwal> listJadwals = data.getListJadwals();
                adapter = new MatkulList(listJadwals);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Try Again Later", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }



}

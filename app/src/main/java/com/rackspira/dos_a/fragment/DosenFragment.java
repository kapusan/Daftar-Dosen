package com.rackspira.dos_a.fragment;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataNamaDosen;
import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by iTPix on 4/4/2018.
 */

public class DosenFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private DosenList adapter;
    private SearchView searchView;
    private ProgressBar progressBar;
    List<ListDosen> listDosens;

    public DosenFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen, container, false);

        listDosens = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_dosen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        progressBar = (ProgressBar) view.findViewById(R.id.progressbar_dosen);

        getJadwalDosen();

        setHasOptionsMenu(true);

        return view;
    }


    private void getJadwalDosen() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataNamaDosen>> call = service.getJadwalDosen();
        call.enqueue(new Callback<BaseResponse<DataNamaDosen>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataNamaDosen>> call, Response<BaseResponse<DataNamaDosen>> response) {
                if (response.isSuccessful()) {
                    listDosens.clear();
                    listDosens.addAll(response.body().getData().getDataDosen());
                    adapter = new DosenList(getContext(), listDosens);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<BaseResponse<DataNamaDosen>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.item, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<ListDosen> newList = new ArrayList<>();
                for (ListDosen listDosen : listDosens){
                    String name = listDosen.getNama_dosen().toLowerCase();
                    if (name.contains(newText))
                        newList.add(listDosen);
                }
                adapter.setFilter(newList);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

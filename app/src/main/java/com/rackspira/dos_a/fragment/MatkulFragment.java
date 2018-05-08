package com.rackspira.dos_a.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataMatkul;
import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.Model.ListMakul;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;
import com.rackspira.dos_a.adapter.MatkulList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import org.w3c.dom.Text;

import java.util.ArrayList;
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
    private ProgressBar progressBar;
    private List<ListMakul> listMakuls;
    private MatkulList adapter;

    public MatkulFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_matkul, container, false);

        listMakuls = new ArrayList<>();
        setHasOptionsMenu(true);

        spinnerSemester = (AppCompatSpinner) view.findViewById(R.id.spinner_semester);
        ArrayAdapter<CharSequence> spinneAdapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.pilihan,
                R.layout.support_simple_spinner_dropdown_item
        );
        spinnerSemester.setAdapter(spinneAdapter);

        final TextView textViewWarning = (TextView)view.findViewById(R.id.textview_warning);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_matkul);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        progressBar = (ProgressBar) view.findViewById(R.id.progressbar_makul);
        getMatkul();
        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        getAdapterRecycler();
                        textViewWarning.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        recyclerView.setVisibility(View.GONE);
                        textViewWarning.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    private void getMatkul() {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataMatkul>> call = service.getJadwalMatkul();
        call.enqueue(new Callback<BaseResponse<DataMatkul>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataMatkul>> call, Response<BaseResponse<DataMatkul>> response) {
                if (response.isSuccessful()) {
                    listMakuls.clear();
                    listMakuls.addAll(response.body().getData().getDataMakul());
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DataMatkul>> call, Throwable t) {

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
                ArrayList<ListMakul> newList = new ArrayList<>();
                for (ListMakul listDosen : listMakuls){
                    String name = listDosen.getMata_kuliah().toLowerCase();
                    if (name.contains(newText))
                        newList.add(listDosen);
                }
                adapter.setFilter(newList);
                return true;
            }
        });
    }

    private void getAdapterRecycler(){
        adapter = new MatkulList(getContext(), listMakuls);
        recyclerView.setAdapter(adapter);
    }

}

package com.rackspira.dos_a.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;

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
        DosenList adapter = new DosenList(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}

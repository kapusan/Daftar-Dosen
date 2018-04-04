package com.rackspira.dos_a.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rackspira.dos_a.R;

/**
 * Created by iTPix on 4/4/2018.
 */

public class DosenFragment extends android.support.v4.app.Fragment{
    public DosenFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dosen,container,false);
        return view;
    }
}

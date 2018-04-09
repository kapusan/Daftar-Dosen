package com.rackspira.dos_a.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rackspira.dos_a.R;

/**
 * Created by Anang S on 03/04/2018.
 */

public class MatkulList extends RecyclerView.Adapter<MatkulList.MyHolder> {
    private Context context;

    public MatkulList(Context context) {
        this.context = context;
    }

    @Override
    public MatkulList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_matkul, parent, false);
        return new MatkulList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MatkulList.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewMatkul, textViewSks;

        public MyHolder(View itemView) {
            super(itemView);
            textViewMatkul = (TextView) itemView.findViewById(R.id.textview_mata_kuliah);
            textViewSks = (TextView) itemView.findViewById(R.id.textview_sks_matkul);

        }
    }
}

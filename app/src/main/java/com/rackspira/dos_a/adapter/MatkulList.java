package com.rackspira.dos_a.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rackspira.dos_a.R;
import com.rackspira.dos_a.Model.ListJadwal;

import java.util.List;

/**
 * Created by Anang S on 03/04/2018.
 */

public class MatkulList extends RecyclerView.Adapter<MatkulList.MyHolder> {

    private List<ListJadwal> listJadwals;

    public MatkulList(List<ListJadwal> listJadwals) {
        this.listJadwals = listJadwals;
    }

    @Override
    public MatkulList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_matkul, parent, false);
        return new MatkulList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MatkulList.MyHolder holder, int position) {
        holder.textViewMatkul.setText(listJadwals.get(position).getNamaMakul());
        holder.textViewSks.setText(listJadwals.get(position).getSks());
    }

    @Override
    public int getItemCount() {
        return listJadwals.size();
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

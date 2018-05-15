package com.rackspira.dos_a.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.Model.ListMakul;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.Model.ListJadwal;
import com.rackspira.dos_a.view.DetailMakulActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anang S on 03/04/2018.
 */

public class MatkulList extends RecyclerView.Adapter<MatkulList.MyHolder> {

    private Context context;
    private List<ListMakul> listJadwals;

    public MatkulList(Context context, List<ListMakul> listJadwals) {
        this.context = context;
        this.listJadwals = listJadwals;
    }

    @Override
    public MatkulList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_matkul, parent, false);
        return new MatkulList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MatkulList.MyHolder holder, final int position) {
        holder.textViewMatkul.setText(listJadwals.get(position).getMata_kuliah());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailMakulActivity.class);
                intent.putExtra("makul", listJadwals.get(position).getMata_kuliah());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJadwals.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewMatkul, textViewSks;
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            textViewMatkul = (TextView) itemView.findViewById(R.id.textview_mata_kuliah);
            Typeface s = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/SourceSansPro-SemiBold.ttf");
            textViewMatkul.setTypeface(s);
            linearLayout = itemView.findViewById(R.id.sample_item_makul);
        }
    }

    public void setFilter(ArrayList<ListMakul> newList){
        listJadwals = new ArrayList<>();
        listJadwals.addAll(newList);
        notifyDataSetChanged();

    }
}

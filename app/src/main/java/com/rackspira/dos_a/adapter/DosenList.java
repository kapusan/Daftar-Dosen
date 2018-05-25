package com.rackspira.dos_a.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.view.DetailDosenActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anang S on 03/04/2018.
 */

public class DosenList extends RecyclerView.Adapter<DosenList.MyHolder> {
    private Context context;
    private List<ListDosen> jadwalList;
    private List<ListDosen> jadwalListFiltered;


    public DosenList(Context context, List<ListDosen> jadwalList) {
        this.context = context;
        this.jadwalList = jadwalList;
        this.jadwalListFiltered = jadwalList;
    }

    @Override
    public DosenList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_dosen, parent, false);
        return new DosenList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(DosenList.MyHolder holder, final int position) {
        holder.textViewNamaDosen.setText(jadwalList.get(position).getNama_dosen());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailDosenActivity.class);
                intent.putExtra("dosen", jadwalList.get(position).getNama_dosen());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewNamaDosen;
        LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            textViewNamaDosen = (TextView) itemView.findViewById(R.id.textview_nama_dosen);
            Typeface s = Typeface.createFromAsset(context.getAssets(), "fonts/listname_font.ttf");
            textViewNamaDosen.setTypeface(s);
            linearLayout = itemView.findViewById(R.id.sample_item_dosen);

        }
    }

    public void setFilter(ArrayList<ListDosen> newList){
        jadwalList = new ArrayList<>();
        jadwalList.addAll(newList);
        notifyDataSetChanged();

    }

}

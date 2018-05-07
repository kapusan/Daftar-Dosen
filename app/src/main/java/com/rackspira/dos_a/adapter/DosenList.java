package com.rackspira.dos_a.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.rackspira.dos_a.Model.ListDosen;
import com.rackspira.dos_a.Model.ListJadwal;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.view.DetailDosenActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anang S on 03/04/2018.
 */

public class DosenList extends RecyclerView.Adapter<DosenList.MyHolder> implements Filterable {
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    jadwalListFiltered = jadwalList;
                } else {
                    List<ListDosen> filteredList = new ArrayList<>();
                    for (ListDosen row : jadwalList) {
                        if (row.getNama_dosen().toLowerCase().contains(charString.toLowerCase())) ;
                        filteredList.add(row);
                    }

                    jadwalListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = jadwalListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                jadwalListFiltered = (ArrayList<ListDosen>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewNamaDosen;
        CardView cardView;

        public MyHolder(View itemView) {
            super(itemView);
            textViewNamaDosen = (TextView) itemView.findViewById(R.id.textview_nama_dosen);
            cardView = itemView.findViewById(R.id.cardview_dosen);

        }
    }


    public interface AdapterListener {
        void onSelectedItem(ListDosen listDosen);
    }
}

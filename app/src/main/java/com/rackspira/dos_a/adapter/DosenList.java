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

public class DosenList extends RecyclerView.Adapter<DosenList.MyHolder> {
    private Context context;

    public DosenList(Context context) {
        this.context = context;
    }

    @Override
    public DosenList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_dosen, parent, false);
        return new DosenList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(DosenList.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textViewNamaDosen, textViewRuangDosen, textViewMatkul, textViewSks, textViewKelas, textViewHari, textViewJam;

        public MyHolder(View itemView) {
            super(itemView);
            textViewNamaDosen = (TextView) itemView.findViewById(R.id.textview_nama_dosen);
            textViewRuangDosen = (TextView) itemView.findViewById(R.id.textview_ruangan_dosen);
            textViewMatkul = (TextView) itemView.findViewById(R.id.textview_mata_kuliah);
            textViewSks = (TextView) itemView.findViewById(R.id.textview_sks);
            textViewKelas = (TextView) itemView.findViewById(R.id.textview_kelas);
            textViewHari = (TextView) itemView.findViewById(R.id.textview_hari);
            textViewJam = (TextView) itemView.findViewById(R.id.textview_jam);
        }
    }
}

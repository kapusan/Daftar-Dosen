package com.rackspira.dos_a.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rackspira.dos_a.Model.ListJadwal;
import com.rackspira.dos_a.R;

import java.util.List;

public class DetailList extends RecyclerView.Adapter<DetailList.MyHolder> {

    private Context context;
    private List<ListJadwal> listJadwals;

    public DetailList(Context context, List<ListJadwal> listJadwals) {
        this.context = context;
        this.listJadwals = listJadwals;
    }

    @Override
    public DetailList.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_detail, parent, false);
        return new DetailList.MyHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailList.MyHolder holder, int position) {
        holder.textViewNamaDosen.setText(listJadwals.get(position).getNamaDosen());
        holder.textViewRuangDosen.setText("Ruang "+listJadwals.get(position).getRuang());
        holder.textViewHari.setText(listJadwals.get(position).getHari()+" ");
        holder.textViewMatkul.setText(listJadwals.get(position).getNamaMakul());
        holder.textViewSks.setText(listJadwals.get(position).getSks()+" SKS");
        holder.textViewKelas.setText("Kelas "+listJadwals.get(position).getKelas());
        holder.textViewJamMulai.setText(listJadwals.get(position).getJamMulai()+" - ");
        holder.textViewJamSelesai.setText(listJadwals.get(position).getJamSelesai());
    }

    @Override
    public int getItemCount() {
        return listJadwals.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final TextView textViewNamaDosen;
        private final TextView textViewRuangDosen;
        private final TextView textViewMatkul;
        private final TextView textViewSks;
        private final TextView textViewKelas;
        private final TextView textViewHari;
        private final TextView textViewJamMulai;
        private final TextView textViewJamSelesai;

        public MyHolder(View itemView) {
            super(itemView);
            textViewNamaDosen = (TextView) itemView.findViewById(R.id.textview_nama_dosen);
            textViewRuangDosen = (TextView) itemView.findViewById(R.id.textview_ruangan_dosen);
            textViewMatkul = (TextView) itemView.findViewById(R.id.textview_mata_kuliah);
            textViewSks = (TextView) itemView.findViewById(R.id.textview_sks);
            textViewKelas = (TextView) itemView.findViewById(R.id.textview_kelas);
            textViewHari = (TextView) itemView.findViewById(R.id.textview_hari);
            textViewJamMulai = (TextView) itemView.findViewById(R.id.textview_jam_mulai);
            textViewJamSelesai = itemView.findViewById(R.id.textview_jam_selesai);
        }
    }
}

package com.rackspira.dos_a.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataJadwal;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DetailList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailDosenActivity extends AppCompatActivity {

    private String TAG = DetailDosenActivity.class.getSimpleName();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dosen);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_dosen);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        TextView tvAppName = findViewById(R.id.textview_dosen_activity);
        Typeface customFontAppName = Typeface.createFromAsset(this.getAssets(), "fonts/appname_font.ttf");
        tvAppName.setTypeface(customFontAppName);

        Intent intent = getIntent();
        String dosen = intent.getStringExtra("dosen");
        Log.d(TAG, "Nama Dosen = " + dosen);
        getDataDetail(dosen);
    }

    private void getDataDetail(String dosen) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        Call<BaseResponse<DataJadwal>> call = service.getDetailDosen(dosen);
        call.enqueue(new Callback<BaseResponse<DataJadwal>>() {
            @Override
            public void onResponse(Call<BaseResponse<DataJadwal>> call, Response<BaseResponse<DataJadwal>> response) {
                if (response.isSuccessful()) {
                    recyclerView = findViewById(R.id.recycler_detail_dosen);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DetailDosenActivity.this));
                    DetailList adapter = new DetailList(DetailDosenActivity.this,
                            response.body().getData().getDataJadwal());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<DataJadwal>> call, Throwable t) {

            }
        });
    }
}

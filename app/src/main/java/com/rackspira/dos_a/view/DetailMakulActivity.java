package com.rackspira.dos_a.view;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.widget.TextView;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataJadwal;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DetailList;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import retrofit2.Callback;
import retrofit2.Response;

public class DetailMakulActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String TAG = DetailMakulActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makul);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_makul);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        TextView tvAppName = findViewById(R.id.textview_matkul_activity);
        Typeface customFontAppName = Typeface.createFromAsset(this.getAssets(), "fonts/appname_font.ttf");
        tvAppName.setTypeface(customFontAppName);

        Intent intent = getIntent();
        String makul = intent.getStringExtra("makul");

        getDataDetail(makul);
    }

    private void getDataDetail(String makul) {
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);
        retrofit2.Call<BaseResponse<DataJadwal>> call = service.getDetailMakul(makul);
        call.enqueue(new Callback<BaseResponse<DataJadwal>>() {
            @Override
            public void onResponse(retrofit2.Call<BaseResponse<DataJadwal>> call, Response<BaseResponse<DataJadwal>> response) {
                if (response.isSuccessful()){
                    recyclerView = findViewById(R.id.recyclerview_detailMakul);
                    recyclerView.setLayoutManager(new LinearLayoutManager(DetailMakulActivity.this));
                    DetailList adapter = new DetailList(DetailMakulActivity.this,
                            response.body().getData().getDataJadwal());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<BaseResponse<DataJadwal>> call, Throwable t) {

            }
        });
    }
}

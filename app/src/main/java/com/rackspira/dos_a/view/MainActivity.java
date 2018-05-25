package com.rackspira.dos_a.view;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.rackspira.dos_a.Model.BaseResponse;
import com.rackspira.dos_a.Model.DataNamaDosen;
import com.rackspira.dos_a.R;
import com.rackspira.dos_a.adapter.DosenList;
import com.rackspira.dos_a.fragment.AboutFragment;
import com.rackspira.dos_a.fragment.DosenFragment;
import com.rackspira.dos_a.fragment.MatkulFragment;
import com.rackspira.dos_a.network.GetDataService;
import com.rackspira.dos_a.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMain;
    private android.support.v7.widget.Toolbar toolbarMain;

    private BottomNavigationView mainNavigation;
    private FrameLayout frameMainNavigation;

    //Declare fragment class
    private MatkulFragment matkulFragment;
    private DosenFragment dosenFragment;
    private AboutFragment aboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle("");
        TextView tvAppName = findViewById(R.id.textview_appname);
        Typeface customFontAppName = Typeface.createFromAsset(this.getAssets(), "fonts/appname_font.ttf");
        tvAppName.setTypeface(customFontAppName);

        mainNavigation = (BottomNavigationView) findViewById(R.id.navigation_main);
        frameMainNavigation = (FrameLayout) findViewById(R.id.navigation_frame);

        matkulFragment = new MatkulFragment();
        dosenFragment = new DosenFragment();
        aboutFragment = new AboutFragment();
        setFragment(matkulFragment);

        mainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.navigation_home :
                        mainNavigation.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(matkulFragment);
                        return true;

                    case R.id.navigation_dosen :
                        mainNavigation.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(dosenFragment);
                        return true;

                    case R.id.navigation_tentang :
                        mainNavigation.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(aboutFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });

    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.navigation_frame, fragment);
        fragmentTransaction.commit();
    }

}

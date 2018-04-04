package com.rackspira.dos_a.view;

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
import android.widget.Spinner;
import android.widget.Toolbar;

import com.rackspira.dos_a.R;
import com.rackspira.dos_a.fragment.AboutFragment;
import com.rackspira.dos_a.fragment.DosenFragment;
import com.rackspira.dos_a.fragment.MatkulFragment;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_credit:

                break;
            case R.id.menu_exit:
                finish();
                break;
        }
        return true;
    }
}

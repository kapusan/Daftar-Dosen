package com.rackspira.dos_a.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.rackspira.dos_a.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMain;
    private android.support.v7.widget.Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        spinnerMain = (Spinner) findViewById(R.id.spinner_main);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(this, R.array.pilihan, R.layout.support_simple_spinner_dropdown_item);
        spinnerMain.setAdapter(adapter);
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
            case R.id.menu_about:

                break;
            case R.id.menu_exit:
                finish();
                break;
        }
        return true;
    }
}

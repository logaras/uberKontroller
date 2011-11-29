package com.ubercontroller;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ControlActivity extends ListActivity {
    private final static String[] ZONES = {"Zone 1", "Zone 2", "Zone 3"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, ZONES));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
             int position, long id) {
                toggleLight();
            }
        });

    }

    private void toggleLight() {
        Toast.makeText(getApplicationContext(), "Toggling Light", Toast.LENGTH_SHORT).show();

    }
}

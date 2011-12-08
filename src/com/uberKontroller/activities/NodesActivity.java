package com.uberKontroller.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.uberKontroller.DepClasses.CapabilitiesActivity;
import com.uberKontroller.R;
import com.uberKontroller.UberApp;

import java.util.ArrayList;

public class NodesActivity extends ListActivity {
    private static String room = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        this.room = bundle.getString("roomKey");

        Log.i(RoomsActivity.TAG, "room is " + room);

        final UberApp uberApp = ((UberApp) getApplicationContext());

        final ArrayList<String> displayList = new ArrayList<String>();
        displayList.addAll(uberApp.getNodesForRoomKey(room).keySet());

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, displayList));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent capabilitiesIntent = new Intent(getApplicationContext(), CapabilitiesActivity.class);
                capabilitiesIntent.putExtra("roomKey", room);
                capabilitiesIntent.putExtra("nodeKey", ((TextView) view).getText());
                startActivity(capabilitiesIntent);
            }
        });

    }

    private void toggleLight() {
        Toast.makeText(getApplicationContext(), "Toggling Light", Toast.LENGTH_SHORT).show();
    }

    protected void onPause(){
       super.onPause();
   }

}

package com.uberKontroller.Activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.uberKontroller.Storage.Capability;
import com.uberKontroller.UberApp;
import com.ubercontroller.R;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CapabilitiesActivity extends ListActivity {
    public static final String TAG = "uberK";
    private String roomKey;
    private String nodeKey;
    private ArrayList<Capability> capsToDisplay = new ArrayList<Capability>();
    private ArrayList<String> capsNames;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final UberApp uberApp = ((UberApp) getApplicationContext());
        Bundle bundle = getIntent().getExtras();

        this.roomKey = bundle.getString("roomKey");
        this.nodeKey = bundle.getString("nodeKey");

        // Display Capabilities for room
        if (roomKey != null && nodeKey == null) {
            Log.i(RoomsActivity.TAG, "Roomkey is " + roomKey);
            this.capsToDisplay = uberApp.getCapabilitiesForRoom(roomKey);
            capsNames = turnCapsToStrings(capsToDisplay);

            // Display Capabilities for node
        } else if (roomKey != null && nodeKey != null) {
            Log.i(RoomsActivity.TAG, "Roomkey is " + roomKey + ", nodeKey is " + nodeKey);
            this.capsToDisplay = uberApp.getCapabilitiesForNode(roomKey,nodeKey);
            capsNames = turnCapsToStrings(capsToDisplay);

        }
        Log.i(RoomsActivity.TAG, "Room " + roomKey + " has " + capsToDisplay.size() + " capabilities");

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, capsNames));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });


    }

    private ArrayList<String> turnCapsToStrings(ArrayList<Capability> roomCaps) {
        final ArrayList<String> roomCapsNames = new ArrayList<String>();
        for (Capability roomCap : roomCaps) {
            roomCapsNames.add(roomCap.getName());

        }
        return roomCapsNames;
    }


}
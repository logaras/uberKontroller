package com.uberKontroller.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.uberKontroller.DataReceiver;
import com.uberKontroller.Services.RestService;
import com.uberKontroller.Storage.Capability;
import com.uberKontroller.Storage.Room;
import com.uberKontroller.UberApp;
import com.ubercontroller.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CapabilitiesActivity extends ListActivity implements DataReceiver.Receiver {
    public static final String TAG = "uberK";
    private ArrayList<Capability> capsToDisplay = new ArrayList<Capability>();
    private ArrayList<String> capsNames;
    public DataReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReceiver = new DataReceiver(new Handler());
        mReceiver.setReceiver(this);

        final UberApp uberApp = ((UberApp) getApplicationContext());
        Bundle bundle = getIntent().getExtras();

        Log.i(UberApp.TAG, "breakpoint");
        final Capability cap = bundle.getParcelable("test");

        final Room room = bundle.getParcelable("roomKey");
        Log.i(UberApp.TAG, "Roomkey is " + room.getDescription());

        final ArrayList<Capability> capabilities = room.getCapabilities();
        Log.i(UberApp.TAG, "has " + capabilities.size());

        // Convert to String
        capsNames = turnCapsToStrings(capabilities);

        // Populate listview
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, capsNames));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                //Toggle

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Capability cap = uberApp.getCapabilitiesForRoom(roomKey);
                Log.d("uberK", ((TextView) view).getText().toString());
                final String capKey = ((TextView) view).getText().toString();
                //requestCapabilityLatestReading(UberApp.getCapability(roomKey,capKey ));

            }
        });


    }

    private void requestCapabilityLatestReading(Capability capability) {
        Toast.makeText(getApplicationContext(), "Requesting Value", Toast.LENGTH_SHORT).show();
        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("url", capability.getlatestReadingURL());
        startService(intent);
        Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_SHORT).show();

    }

    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(TAG, "Communication Received Result");
        switch (resultCode) {
            case 1:
                Toast.makeText(getApplicationContext(), "Value: ", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                List results;
                // do something interesting
                // hide progress
                break;
            case 3:
                // handle the error;
                break;
        }

    }


    public void onPause() {
        mReceiver.setReceiver(null); // clear receiver so no leaks.
    }

    private ArrayList<String> turnCapsToStrings(ArrayList<Capability> roomCaps) {
        final ArrayList<String> roomCapsNames = new ArrayList<String>();
        for (Capability roomCap : roomCaps) {
            roomCapsNames.add(roomCap.getName());

        }
        return roomCapsNames;
    }


}
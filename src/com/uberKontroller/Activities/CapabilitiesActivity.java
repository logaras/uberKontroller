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
import com.uberKontroller.Storage.Node;
import com.uberKontroller.UberApp;
import com.ubercontroller.R;

import java.util.ArrayList;
import java.util.HashMap;
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
    public DataReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReceiver = new DataReceiver(new Handler());
        mReceiver.setReceiver(this);

        final UberApp uberApp = ((UberApp) getApplicationContext());
        Bundle bundle = getIntent().getExtras();

        final String roomKey = bundle.getString("roomKey");
        Log.i(UberApp.TAG, "Roomkey is " + roomKey);

        final HashMap<String, Node> roomNodes = uberApp.getRooms().get(roomKey).getNodes();

        final HashMap<String, Capability> roomCapabilities = new HashMap<String, Capability>();

        for (Node roomNode : roomNodes.values()) {
            final HashMap<String, Capability> nodeCaps = roomNode.getCapabilities();

            for (Capability nodeCap : nodeCaps.values()) {
                roomCapabilities.put(nodeCap.getName(),nodeCap);
                if(nodeCap.getLatestReadingURL() == null){
                    Log.d(UberApp.TAG,"OMG!");
                }
            }
        }

        Log.i(UberApp.TAG, " has " + roomCapabilities.size());

        // Populate listview
        final ArrayList<String> displayList = new ArrayList<String>();
        displayList.addAll(roomCapabilities.keySet());
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, displayList));

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

                final String capName = ((TextView) view).getText().toString();
                Capability cap = roomCapabilities.get(capName);
                Log.d(UberApp.TAG, capName + " " + cap.getLatestReadingURL());
                //final String capKey = ((TextView) view).getText().toString();
                requestCapabilityLatestReading(cap);

            }
        });


    }

    private void requestCapabilityLatestReading(Capability capability) {

        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("restUrl", capability.getLatestReadingURL());

        startService(intent);


    }

    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(TAG, "Communication Received Result");
        switch (resultCode) {
            case 1:
                final String  rawResponse = (String) resultData.get("rawResponse");
                final String value = rawResponse.substring(rawResponse.indexOf("\t"));

                Toast.makeText(getApplicationContext(), "Value: " + value , Toast.LENGTH_SHORT).show();
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

}
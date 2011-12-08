package com.uberKontroller.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.uberKontroller.R;
import com.uberKontroller.UberApp;
import com.uberKontroller.activities.adapters.ClickableAdapter;
import com.uberKontroller.services.DataReceiver;
import com.uberKontroller.services.RestService;
import com.uberKontroller.storage.Capability;
import com.uberKontroller.storage.Node;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Demonstrates how to write an efficient list adapter. The adapter used in this example binds
 * to an ImageView and to a TextView for each row in the list.
 * <p/>
 * To work efficiently the adapter implemented here uses two techniques:
 * - It reuses the convertView passed to getView() to avoid inflating View when it is not necessary
 * - It uses the ViewHolder pattern to avoid calling findViewById() when it is not necessary
 * <p/>
 * The ViewHolder pattern consists in storing a data structure in the tag of the view returned by
 * getView(). This data structures contains references to the views we want to bind data to, thus
 * avoiding calls to findViewById() every time getView() is invoked.
 */
public class CapabilitiesActivity extends ListActivity implements DataReceiver.Receiver {
    public DataReceiver mReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UberApp uberApp = ((UberApp) getApplicationContext());

        mReceiver = new DataReceiver(new Handler());
        mReceiver.setReceiver(this);

        Bundle bundle = getIntent().getExtras();

        final String roomKey = bundle.getString("roomKey");
        Log.i(UberApp.TAG, "Roomkey is " + roomKey);

        final HashMap<String, Node> roomNodes = uberApp.getRooms().get(roomKey).getNodes();

        final LinkedList<Capability> roomCapabilities = new LinkedList<Capability>();

        for (Node roomNode : roomNodes.values()) {
            final HashMap<String, Capability> nodeCaps = roomNode.getCapabilities();

            for (Capability nodeCap : nodeCaps.values()) {
                roomCapabilities.add(nodeCap);
                if (nodeCap.getLatestReadingURL() == null) {
                    Log.d(UberApp.TAG, "OMG!");
                }
            }
        }


        Log.d(UberApp.TAG, roomCapabilities.size() + " capabilities restored");
        setListAdapter(new ClickableAdapter(this, R.layout.cap_row, roomCapabilities));


    }


    public void requestCapabilityLatestReading(Capability capability) {


        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("restUrl", capability.getLatestReadingURL());

        startService(intent);

    }

    public void toggleCapabilityStatus(Capability capability) {
        String restUrl = "";
        if (capability.getLatestReading() == 0) {
            // Set on
            restUrl = capability.getOnUrl();
        } else if (capability.getLatestReading() > 0) {
            //Set off
            restUrl = capability.getOffUrl();
        }
        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("restUrl", restUrl);

        startService(intent);

    }

    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(UberApp.TAG, "Communication Received Result");
        switch (resultCode) {
            case 1:
                final String rawResponse = (String) resultData.get("rawResponse");
                if (rawResponse.contains("\t")) {

                    final String value = rawResponse.substring(rawResponse.indexOf("\t"));
                    Toast.makeText(getApplicationContext(), "Value: " + value, Toast.LENGTH_LONG).show();
                } else if(rawResponse.contains("OK")) {
                    Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                } else{
                   Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_LONG).show();
                }

                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Error.Sorry.", Toast.LENGTH_LONG).show();
                break;
            case 3:
                // handle the error;
                break;
        }

    }

    public void onPause() {
        super.onPause();
        mReceiver.setReceiver(null); // clear receiver so no leaks.
    }


}
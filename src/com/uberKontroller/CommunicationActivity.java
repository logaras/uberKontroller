package com.uberKontroller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.uberKontroller.Activities.RoomsActivity;
import com.uberKontroller.Services.RestService;
import com.ubercontroller.R;

import java.util.List;

public class CommunicationActivity extends ListActivity implements DataReceiver.Receiver {
    private final static String[] ZONES = {"Zone 1", "Zone 2", "Zone 3"};
    public DataReceiver mReceiver;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(RoomsActivity.TAG, "Communication Activity");
        mReceiver = new DataReceiver(new Handler());
        mReceiver.setReceiver(this);



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

    public void onPause() {
        mReceiver.setReceiver(null); // clear receiver so no leaks.
    }

    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(RoomsActivity.TAG , "Communication Received Result");
        switch (resultCode) {
            case 1:
                Log.d(RoomsActivity.TAG , "Result: " + resultData.toString());
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

    private void toggleLight() {
        Toast.makeText(getApplicationContext(), "Toggling Light 1/2", Toast.LENGTH_SHORT).show();

        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        //intent.putExtra("url", "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x494/capability/urn:wisebed:node:capability:light1/latestreading");
        intent.putExtra("url", "http://uberdust.cti.gr/rest/sendCommand/destination/urn:wisebed:ctitestbed:0x494/payload/1,FF,1");
        startService(intent);
        Toast.makeText(getApplicationContext(), "Toggling Light 2/2", Toast.LENGTH_SHORT).show();



    }
}

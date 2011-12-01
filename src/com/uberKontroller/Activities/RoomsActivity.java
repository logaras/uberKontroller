package com.uberKontroller.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.uberKontroller.Storage.Capability;
import com.uberKontroller.Storage.Room;
import com.uberKontroller.UberApp;
import com.ubercontroller.R;

public class RoomsActivity extends ListActivity {
    public static final String TAG = "uberK";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final UberApp uberApp = ((UberApp) getApplicationContext());
        Log.d(TAG, "UberApp has " + uberApp.getRooms().size() + " rooms");


        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, uberApp.getRoomsDescriptions()));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                Intent nodesIntent = new Intent(getApplicationContext(), NodesActivity.class);
                final String selectedRoomName = ((TextView) view).getText().toString();
                final Room room =  uberApp.getRooms().get(selectedRoomName);
                nodesIntent.putExtra("roomKey", room);
                startActivity(nodesIntent);

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                Intent capabilitesIntent = new Intent(getApplicationContext(), CapabilitiesActivity.class);
                final String selectedRoomName = ((TextView) view).getText().toString();
                final Room room =  uberApp.getRooms().get(selectedRoomName);
                capabilitesIntent.putExtra("roomKey", room);
                capabilitesIntent.putExtra("test",new Capability());
                startActivity(capabilitesIntent);
            }
        });


    }


}

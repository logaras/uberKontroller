package com.uberKontroller.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.uberKontroller.UberApp;
import com.ubercontroller.R;

public class NodesActivity extends ListActivity {
    private static String room = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        this.room = bundle.getString("roomKey");

        Log.i(RoomsActivity.TAG, "room is " + room);

        final UberApp uberApp = ((UberApp) getApplicationContext());

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,uberApp.getNodesIdsForRoom(room)));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                Intent nodesIntent = new Intent(getApplicationContext(), CapabilitiesActivity.class);
                nodesIntent.putExtra("roomKey", room);
                nodesIntent.putExtra("nodeKey", ((TextView) view).getText());
                startActivity(nodesIntent);
            }
        });

    }

    private void toggleLight() {
        Toast.makeText(getApplicationContext(), "Toggling Light", Toast.LENGTH_SHORT).show();
    }
}

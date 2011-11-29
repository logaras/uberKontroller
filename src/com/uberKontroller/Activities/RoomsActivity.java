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
                nodesIntent.putExtra("roomKey", ((TextView) view).getText());
                startActivity(nodesIntent);

                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                           int position, long id) {


                Intent nodesIntent = new Intent(getApplicationContext(), CapabilitiesActivity.class);
                nodesIntent.putExtra("roomKey", ((TextView) view).getText());
                startActivity(nodesIntent);
            }
        });


    }


}

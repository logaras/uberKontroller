package com.uberKontroller;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.ubercontroller.R;

public class UberKontroller extends ListActivity {
    private final static String[] ROOMS = {"0.I.1", "0.I.2","0.I.3"};

  @Override
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);

  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, ROOMS));

  ListView lv = getListView();
  lv.setTextFilterEnabled(true);

  lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
        //Intent controlIntent = new Intent(getApplicationContext(), ControlActivity.class);
        //startActivity(controlIntent);

        Intent controlIntent = new Intent(getApplicationContext(), CommunicationActivity.class);
        startActivity(controlIntent);

    }
  });



}
}

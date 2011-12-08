package com.uberKontroller.Activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.uberKontroller.DepClasses.DataReceiver;
import com.uberKontroller.R;
import com.uberKontroller.Services.RestService;
import com.uberKontroller.Storage.Capability;
import com.uberKontroller.Storage.Node;
import com.uberKontroller.UberApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

    private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Bitmap mIcon1;
        private Bitmap mIcon2;
        private LinkedList<Capability> mCapabilities;


        public EfficientAdapter(Context context, LinkedList<Capability> capabilities) {

            // Cache the LayoutInflate to avoid asking for a new one each time.
            mInflater = LayoutInflater.from(context);

            // Icons bound to the rows.
            mIcon1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon);
            mIcon2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon);

            mCapabilities = capabilities;
            Log.d(UberApp.TAG, getCount() + " capabilities to show");
        }

        /**
         * The number of items in the list is determined by the number of speeches
         * in our array.
         *
         * @see android.widget.ListAdapter#getCount()
         */
        public int getCount() {
            return mCapabilities.size();
        }

        /**
         * Since the data comes from an array, just returning the index is
         * sufficent to get at the data. If we were using a more complex data
         * structure, we would return whatever object represents one row in the
         * list.
         *
         * @see android.widget.ListAdapter#getItem(int)
         */
        public Object getItem(int position) {
            return position;
        }

        /**
         * Use the array index as a unique id.
         *
         * @see android.widget.ListAdapter#getItemId(int)
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         * Make a view to hold each row.
         *
         * @see android.widget.ListAdapter#getView(int, android.view.View,
         *      android.view.ViewGroup)
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            // A ViewHolder keeps references to children views to avoid unneccessary calls
            // to findViewById() on each row.
            ViewHolder holder;

            // When convertView is not null, we can reuse it directly, there is no need
            // to reinflate it. We only inflate a new View when the convertView supplied
            // by ListView is null.
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.cap_row, null);

                // Creates a ViewHolder and store references to the two children views
                // we want to bind data to.
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.text);
                holder.icon = (ImageView) convertView.findViewById(R.id.icon);

                convertView.setTag(holder);
            } else {
                // Get the ViewHolder back to get fast access to the TextView
                // and the ImageView.
                holder = (ViewHolder) convertView.getTag();
            }

            // Bind the data efficiently with the holder.
            holder.text.setText(mCapabilities.get(position).toString());
            holder.icon.setImageBitmap((position & 1) == 1 ? mIcon1 : mIcon2);

            return convertView;
        }

        static class ViewHolder {
            TextView text;
            ImageView icon;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UberApp uberApp = ((UberApp) getApplicationContext());

        mReceiver = new DataReceiver(new Handler());
        //mReceiver.setReceiver(this);

        Bundle bundle = getIntent().getExtras();

        final String roomKey = bundle.getString("roomKey");
        Log.i(UberApp.TAG, "Roomkey is " + roomKey);

        final HashMap<String, Node> roomNodes = uberApp.getRooms().get(roomKey).getNodes();

        final HashMap<String, Capability> roomCapabilities = new HashMap<String, Capability>();

        for (Node roomNode : roomNodes.values()) {
            final HashMap<String, Capability> nodeCaps = roomNode.getCapabilities();

            for (Capability nodeCap : nodeCaps.values()) {
                roomCapabilities.put(nodeCap.getName(), nodeCap);
                if (nodeCap.getLatestReadingURL() == null) {
                    Log.d(UberApp.TAG, "OMG!");
                }
            }
        }


        Log.d(UberApp.TAG,roomCapabilities.values().size() + " capabilities restored");
        setListAdapter(new EfficientAdapter(this, new LinkedList<Capability>(roomCapabilities.values())));



    }


    private void requestCapabilityLatestReading(Capability capability) {

        final Intent intent = new Intent(Intent.ACTION_SYNC, null, this, RestService.class);
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("restUrl", capability.getLatestReadingURL());

        startService(intent);


    }

    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(UberApp.TAG, "Communication Received Result");
        switch (resultCode) {
            case 1:
                final String  rawResponse = (String) resultData.get("rawResponse");
                final String value = rawResponse.substring(rawResponse.indexOf("\t"));

                Toast.makeText(getApplicationContext(), "Value: " + value, Toast.LENGTH_LONG).show();
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
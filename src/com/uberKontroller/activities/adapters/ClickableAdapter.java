package com.uberKontroller.activities.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.uberKontroller.R;
import com.uberKontroller.UberApp;
import com.uberKontroller.activities.CapabilitiesActivity;
import com.uberKontroller.storage.Capability;

import java.util.LinkedList;

public class ClickableAdapter extends AbstractClickableAdapter {
    Context context;

    public ClickableAdapter(Context context, int viewid, LinkedList<Capability> objects) {
        super(context, viewid, objects);
        this.context = context;
    }

    protected void bindHolder(AbstractClickableAdapter.ViewHolder h) {


        CapabilityViewHolder capViewHolder = (CapabilityViewHolder) h;
        Capability cap = (Capability) capViewHolder.data;

        capViewHolder.text.setText(cap.toString());
        //capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
        if (cap.toString().contains("co") || cap.toString().contains("ch") || cap.toString().contains("CO")) {
            capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.air));

        } else if (cap.toString().contains("temperature")) {
            capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.temperature));
        } else if (cap.toString().contains("ir")) {
            capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.ir));
        } else if (cap.toString().contains("pressure")) {
            capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.pressure));
        } else if (cap.toString().equals("light")) {
           capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.lightbulb));
        } else if (cap.toString().contains("light")) {
           capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.onoff));
        }else {
            capViewHolder.icon.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon));
        }


    }

    @Override
    protected AbstractClickableAdapter.ViewHolder createHolder(View v) {

        TextView text = (TextView) v.findViewById(R.id.text);
        ImageView icon = (ImageView) v.findViewById(R.id.icon);

        ViewHolder mvh = new CapabilityViewHolder(text, icon);

        text.setOnClickListener(new AbstractClickableAdapter.OnClickListener(mvh) {

            public void onClick(View v, ViewHolder viewHolder) {

                final CapabilityViewHolder capabilityViewHolder = (CapabilityViewHolder) viewHolder;
                final Capability selectedCapability = (Capability) capabilityViewHolder.data;
                Log.d(UberApp.TAG, "shrt click for " + selectedCapability.toString());
                ((CapabilitiesActivity) context).requestCapabilityLatestReading(selectedCapability);


            }
        });


        text.setOnLongClickListener(new OnLongClickListener(mvh) {

            @Override
            public void onLongClick(View v, ViewHolder viewHolder) {

                final CapabilityViewHolder capabilityViewHolder = (CapabilityViewHolder) viewHolder;
                final Capability selectedCapability = (Capability) capabilityViewHolder.data;
                if(!selectedCapability.isSettable()){
                    Toast.makeText(context, selectedCapability.getName() + " cannot be set", Toast.LENGTH_LONG).show();
                }

            }

        });

        return mvh;
    }

    static class CapabilityViewHolder extends ViewHolder {
        TextView text;
        ImageView icon;

        public CapabilityViewHolder(TextView t, ImageView i) {
            text = t;
            icon = i;
        }

    }


}
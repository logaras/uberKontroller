package com.uberKontroller.Activities;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.uberKontroller.Storage.Capability;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 12/6/11
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class CapabilitiesAdapter extends BaseAdapter {

    /**
     * Remember our context so we can use it when constructing views.
     */
    private Context mContext;

    /**
     * Hold onto a copy of the entire Contact List.
     */
    private List<Capability> mItems = new ArrayList<Capability>();

    public CapabilitiesAdapter(Context context, ArrayList<Capability> items) {
        mContext = context;
        mItems = items;
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    /**
     * Use the array index as a unique id.
     */
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param convertView The old view to overwrite, if one is passed
     * @returns a ContactEntryView that holds wraps around an ContactEntry
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        CapabilityView btv;
        if (convertView == null) {
            btv = new CapabilityView(mContext, mItems.get(position));
        } else {
            btv = (CapabilityView) convertView;
            String name = mItems.get(position).getName();
            btv.setNameText(name);
            String number = mItems.get(position).getName();
            if (number != null) {
                btv.setNumberText("Mobile: " + mItems.get(position).getName());
            }
        }
        return btv;
    }
}

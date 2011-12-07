package com.uberKontroller.Activities;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uberKontroller.Storage.Capability;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 12/7/11
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class CapabilityView extends LinearLayout {

    private TextView mName;
    private TextView mNumber;

    public CapabilityView(Context context, Capability capability) {
        super(context);
        this.setOrientation(VERTICAL);
        mName = new TextView(context);
        mNumber = new TextView(context);

        String name = capability.getName();
        mName.setText(name);
        mName.setTextSize(19);
        mName.setTextColor(Color.BLACK);
        mName.setTypeface(Typeface.SANS_SERIF);

        String number = ""+capability.getLatestReading();
        mNumber.setText("Value: " + capability.getLatestReading());
        mNumber.setTextSize(14);
        mNumber.setTypeface(Typeface.SANS_SERIF);

        addView(mName, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(mNumber, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    public String getNameText() {
        return mName.getText().toString();
    }

    public String getNumberText() {
        return mNumber.getText().toString();
    }

    public void setNameText(String name) {
        mName.setText(name);
    }

    public void setNumberText(String number) {
        mNumber.setText(number);
    }

}

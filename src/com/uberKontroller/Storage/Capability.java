package com.uberKontroller.Storage;

import android.util.Log;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Capability {
    private String name;
    private double latestReading;
    private boolean isSettable;
    private String latestReadingURL;

    public String getlatestReadingURLL() {
        return latestReadingURL;
    }

    public void setlatestReadingURL(String URL) {
        this.latestReadingURL = URL;
    }

    public Capability() {
        name = "nodeCap";
        latestReading = 0.0;
        isSettable = false;
        latestReadingURL= "url";

    }

    public Capability(String name, double latestReading, boolean settable) {
        this.name = name;
        this.latestReading = latestReading;
        isSettable = settable;
    }

    public Capability(String name, double latestReading, boolean settable, final String URLbase) {
        this.name = name;
        this.latestReading = latestReading;
        this.isSettable = settable;

        this.latestReadingURL = URLbase  + name + "/latestreading";

        Log.d("TEST",this.latestReadingURL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatestReading() {
        return latestReading;
    }

    public void setLatestReading(double latestReading) {
        this.latestReading = latestReading;
    }

    public boolean isSettable() {
        return isSettable;
    }

    public void setSettable(boolean settable) {
        isSettable = settable;
    }
}

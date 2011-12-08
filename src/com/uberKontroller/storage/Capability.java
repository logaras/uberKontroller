package com.uberKontroller.storage;

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
    private String nodeId;
    private double latestReading;
    private boolean isSettable;
    private String latestReadingURL;
    private String onUrl;
    private String offUrl;

    public String getOnUrl() {
        return onUrl;
    }

    public void setOnUrl(String onUrl) {
        this.onUrl = onUrl;
    }

    public String getOffUrl() {
        return offUrl;
    }

    public void setOffUrl(String offUrl) {
        this.offUrl = offUrl;
    }

    public String getLatestReadingURL() {
        return latestReadingURL;
    }

    public void setLatestReadingURL(String latestReadingURL) {
        this.latestReadingURL = latestReadingURL;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;

        if (isSettable) {
            //http://uberdust.cti.gr/rest/sendCommand/destination/urn:wisebed:ctitestbed:0x494/payload/1,FF,1


            this.onUrl = "http://uberdust.cti.gr/rest/sendCommand/destination/" + nodeId + "/payload/1,"+this.toString().substring(5,6)+",1";
            this.offUrl = "http://uberdust.cti.gr/rest/sendCommand/destination/" + nodeId + "/payload/1,"+this.toString().substring(5,6)+",0";

        }
    }

    public Capability() {
        name = "nodeCap";
        latestReading = 0.0;
        isSettable = false;
        latestReadingURL = "url";

    }

    public Capability(String name, double latestReading, boolean settable) {
        this.name = name;
        this.latestReading = latestReading;
        isSettable = settable;
    }

    public Capability(final String name, final double latestReading, final boolean settable, final String URLbase) {
        this.name = name;
        this.latestReading = latestReading;
        this.isSettable = settable;

        this.latestReadingURL = URLbase + name + "/latestreading";

        Log.d("TEST", this.latestReadingURL);
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

    @Override
    public String toString() {
        return name.substring(name.lastIndexOf(":") + 1);
    }

}

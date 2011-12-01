package com.uberKontroller.Storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.uberKontroller.UberApp;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Capability implements Parcelable {
    private String name;
    private String nodeId;
    private double latestReading;
    private boolean isSettable;
    private String latestReadingURL;

    public Capability(Parcel in) {
        readFromParcel(in);
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
    }

    public String getlatestReadingURL() {
        return latestReadingURL;
    }

    public void setlatestReadingURL(String URL) {
        this.latestReadingURL = URL;
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

    public Capability(String name, double latestReading, boolean settable, final String URLbase) {
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

    public int describeContents() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeDouble(latestReading);
        parcel.writeInt(isSettable ? 0 : 1);
        parcel.writeString(latestReadingURL);
    }

    public void readFromParcel(final Parcel parcel) {
        name = parcel.readString();
        latestReading = parcel.readDouble();
        isSettable = parcel.readInt() == 0;
        latestReadingURL = parcel.readString();
    }

    @Override
    public String toString() {
        return name;
    }

    public static final Parcelable.Creator<Capability> CREATOR = new
            Parcelable.Creator<Capability>() {
                public Capability createFromParcel(Parcel in) {
                    Log.v(UberApp.TAG + " Capability", "Creating from parcel");
                    return new Capability(in);
                }

                public Capability[] newArray(int size) {
                    return new Capability[size];
                }
            };

}

package com.uberKontroller.Storage;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.uberKontroller.UberApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node implements Parcelable {
    private String id;
    private List<Capability> capabilities;
    private String URL;

    public Node() {
        id = "nodeId";
        URL = "http://restUrl";
        capabilities = new ArrayList<Capability>();
    }

    public Node(final String id, final List<Capability> capabilities, final String URL) {
        this.id = id;
        this.capabilities = capabilities;
        this.URL = URL;
    }

    public Node(final String id, final List<Capability> capabilities) {
        this.id = id;
        this.capabilities = capabilities;
        this.URL = URL;
    }

    public Node(Parcel in) {
        capabilities = new ArrayList<Capability>();
        readFromParcel(in);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }

    public int describeContents() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void writeToParcel(Parcel parcel, int i) {
        //id;
        parcel.writeString(id);

        //List<Capability> capabilities;
        parcel.writeInt(capabilities.size());
        for (Capability capability : capabilities) {
            parcel.writeParcelable(capability, 0);
        }
        //String URL;
        parcel.writeString(URL);
    }


    public void readFromParcel(final Parcel in) {
        id = in.readString();

        final int capSize = in.readInt();
        for (int i = 0; i < capSize; i++) {
            capabilities.add((Capability) in.readValue(Capability.class.getClassLoader()));
        }
        URL = in.readString();
    }

    public static final Parcelable.Creator<Node> CREATOR = new
            Parcelable.Creator<Node>() {
                public Node createFromParcel(Parcel in) {
                    Log.v(UberApp.TAG + " Node", "Creating from parcel");
                    return new Node(in);
                }

                public Node[] newArray(int size) {
                    return new Node[size];
                }
            };
}

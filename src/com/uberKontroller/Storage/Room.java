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
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Room implements Parcelable {
    private String description;
    private List<Node> nodes;

    public Room() {
        this.description = "desc";
        this.nodes = new ArrayList<Node>();
    }

    public Room(final String description, final List<Node> nodes) {
        this.description = description;
        this.nodes = nodes;
    }

    public Room(Parcel in) {
        nodes = new ArrayList<Node>();
        readFormParcel(in);

    }

    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(description);
        dest.writeInt(nodes.size());

        for (Node node : nodes) {
            dest.writeParcelable(node, 0);
        }

    }

    public void readFormParcel(Parcel in) {
        description = in.readString();
        final int nodeCount = in.readInt();
        for (int i = 0; i < nodeCount; i++) {
            nodes.add((Node) in.readValue(Node.class.getClassLoader()));
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Capability> getCapabilities() {
        final ArrayList<Capability> capabilities = new ArrayList<Capability>();
        for (Node node : nodes) {
            capabilities.addAll(node.getCapabilities());
        }
        return capabilities;
    }

    public static final Parcelable.Creator<Room> CREATOR = new
            Parcelable.Creator<Room>() {
                public Room createFromParcel(Parcel in) {
                    Log.v(UberApp.TAG + " Room", "Creating from parcel");
                    return new Room(in);
                }

                public Room[] newArray(int size) {
                    return new Room[size];
                }
            };


}

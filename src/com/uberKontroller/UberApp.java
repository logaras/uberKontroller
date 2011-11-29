package com.uberKontroller;

import android.app.Application;
import com.uberKontroller.Storage.Capability;
import com.uberKontroller.Storage.Node;
import com.uberKontroller.Storage.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class UberApp extends Application {
    public final static String TAG = "uberK";
    private HashMap<String, Room> rooms;

    public void onCreate() {
        super.onCreate();
        initGlobalStorage();
    }


    public void initGlobalStorage() {
        rooms = new HashMap<String, Room>();

        final ArrayList<Node> nodesI01 = new ArrayList<Node>();

        final ArrayList<Capability> capabilities_1ed4 = new ArrayList<Capability>();
        capabilities_1ed4.add(new Capability("urn:wisebed:node:capability:humidity", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.add(new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.add(new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.add(new Capability("urn:wisebed:node:capability:ir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));

        nodesI01.add(new Node("urn:wisebed:ctitestbed:0x1ed4", capabilities_1ed4, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/"));



        final ArrayList<Capability> capabilities_ca3 = new ArrayList<Capability>();
        //urn:wisebed:ctitestbed:0xca3
        capabilities_ca3.add(new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        capabilities_ca3.add(new Capability("urn:wisebed:node:capability:temperature ", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        capabilities_ca3.add(new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        nodesI01.add(new Node("urn:wisebed:ctitestbed:0xca3", capabilities_ca3, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/"));


        ArrayList<Capability> capabilities_1cde = new ArrayList<Capability>();
        capabilities_1cde.add(new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        capabilities_1cde.add(new Capability("urn:wisebed:node:capability:temperature ", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        capabilities_1cde.add(new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        nodesI01.add(new Node("urn:wisebed:ctitestbed:0x1cde", capabilities_1cde, "http://restful/url/0x494"));

        List<Capability> capabilities_99c = new ArrayList<Capability>();
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:light4", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:light2", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:light3", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:light1", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:co", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:ch4", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:temperature ", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:CH4", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:CO2", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.add(new Capability("urn:wisebed:node:capability:co2", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        nodesI01.add(new Node("urn:wisebed:ctitestbed:0x99c", capabilities_99c, "http://restful/url/0x494"));


        List<Capability> capabilities_cad = new ArrayList<Capability>();
        capabilities_cad.add(new Capability("urn:wisebed:node:capability:pressure", 0.0, false));
        nodesI01.add(new Node("urn:wisebed:ctitestbed:0xcad", capabilities_cad, "http://restful/url/0x494"));

         rooms.put("0.I.1",new Room("0.I.1",nodesI01));


        // Dummy staff
        final ArrayList<Node> dummyNodes = new ArrayList<Node>();
        final ArrayList<Capability> dummyCaps = new ArrayList<Capability>();
        dummyCaps.add(new Capability());
        dummyCaps.add(new Capability());
        dummyCaps.add(new Capability());

        final Node dummyNode = new Node();
        dummyNode.setCapabilities(dummyCaps);

        dummyNodes.add(dummyNode);
        dummyNodes.add(dummyNode);
        dummyNodes.add(dummyNode);


        rooms.put("0.I.3", new Room("0.I.11", dummyNodes));
        rooms.put("0.I.11", new Room("0.I.11", dummyNodes));

    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public ArrayList<String> getRoomsDescriptions() {
        final ArrayList<String> roomNames = new ArrayList<String>();
        for (String roomName : rooms.keySet()) {
            roomNames.add(roomName);

        }
        return roomNames;
    }


/*    public ArrayList<Node> getNodesForRoom(final String roomKey){
        return (ArrayList<Node>) rooms.get(roomKey).getNodes();
    }*/

    public ArrayList<String> getNodesIdsForRoom(final String roomKey) {
        final ArrayList<String> nodesIds = new ArrayList<String>();
        final ArrayList<Node> nodes = (ArrayList<Node>) rooms.get(roomKey).getNodes();

        for (Node node : nodes) {
            nodesIds.add(node.getId());
        }
        return nodesIds;
    }

    public ArrayList<Capability> getCapabilitiesForRoom(final String roomKey) {
        final ArrayList<Capability> allCaps = new ArrayList<Capability>();

        final ArrayList<Node> roomNodes = (ArrayList<Node>) rooms.get(roomKey).getNodes();

        for (Node roomNode : roomNodes) {
            final ArrayList<Capability> nodeCaps = (ArrayList<Capability>) roomNode.getCapabilities();
            for (Capability nodeCap : nodeCaps) {
                allCaps.add(nodeCap);
            }
        }
        return allCaps;
    }

    public ArrayList<Capability> getCapabilitiesForNode(final String roomKey,final String nodeKey) {
         final ArrayList<Capability> allCaps = new ArrayList<Capability>();

        final ArrayList<Node> roomNodes = (ArrayList<Node>) rooms.get(roomKey).getNodes();

        for (Node roomNode : roomNodes) {
            final ArrayList<Capability> nodeCaps = (ArrayList<Capability>) roomNode.getCapabilities();
            for (Capability nodeCap : nodeCaps) {
                allCaps.add(nodeCap);
            }
        }
        return allCaps;
    }
}

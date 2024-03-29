package com.uberKontroller;

import android.app.Application;
import android.util.Log;
import com.uberKontroller.storage.Capability;
import com.uberKontroller.storage.Node;
import com.uberKontroller.storage.Room;

import java.util.ArrayList;
import java.util.HashMap;

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

        final HashMap<String, Node> nodesI01 = new HashMap<String, Node>();

        final HashMap<String, Capability> capabilities_1ed4 = new HashMap<String, Capability>();
        capabilities_1ed4.put("urn:wisebed:node:capability:humidity", new Capability("urn:wisebed:node:capability:humidity", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));
        capabilities_1ed4.put("urn:wisebed:node:capability:ir", new Capability("urn:wisebed:node:capability:ir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/capability/"));

        nodesI01.put("urn:wisebed:ctitestbed:0x1ed4", new Node("urn:wisebed:ctitestbed:0x1ed4", capabilities_1ed4, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1ed/"));


        final HashMap<String, Capability> capabilities_ca3 = new HashMap<String, Capability>();
        //urn:wisebed:ctitestbed:0xca3
        capabilities_ca3.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        capabilities_ca3.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        capabilities_ca3.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/capability/"));
        nodesI01.put("urn:wisebed:ctitestbed:0xca3", new Node("urn:wisebed:ctitestbed:0xca3", capabilities_ca3, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xca3/"));


        HashMap<String, Capability> capabilities_1cde = new HashMap<String, Capability>();
        capabilities_1cde.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        capabilities_1cde.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        capabilities_1cde.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x1cde/capability/"));
        nodesI01.put("urn:wisebed:ctitestbed:0x1cde", new Node("urn:wisebed:ctitestbed:0x1cde", capabilities_1cde, "http://restful/url/0x494"));

        HashMap<String, Capability> capabilities_99c = new HashMap<String, Capability>();
        capabilities_99c.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:light4", new Capability("urn:wisebed:node:capability:light4", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:light2", new Capability("urn:wisebed:node:capability:light2", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:light3", new Capability("urn:wisebed:node:capability:light3", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:light1", new Capability("urn:wisebed:node:capability:light1", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:co", new Capability("urn:wisebed:node:capability:co", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:ch4", new Capability("urn:wisebed:node:capability:ch4", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:CH4", new Capability("urn:wisebed:node:capability:CH4", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:CO2", new Capability("urn:wisebed:node:capability:CO2", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        capabilities_99c.put("urn:wisebed:node:capability:co2", new Capability("urn:wisebed:node:capability:co2", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x99c/capability/"));
        nodesI01.put("urn:wisebed:ctitestbed:0x99c", new Node("urn:wisebed:ctitestbed:0x99c", capabilities_99c, "http://restful/url/0x494"));


        HashMap<String, Capability> capabilities_cad = new HashMap<String, Capability>();
        capabilities_cad.put("urn:wisebed:node:capability:pressure", new Capability("urn:wisebed:node:capability:pressure", 0.0, false));
        nodesI01.put("urn:wisebed:ctitestbed:0xcad", new Node("urn:wisebed:ctitestbed:0xcad", capabilities_cad, "http://restful/url/0x494"));

        rooms.put("0.I.1", new Room("0.I.1", nodesI01));


        // Dummy staff
        final HashMap<String, Node> dummyNodes = new HashMap<String, Node>();
        final HashMap<String, Capability> dummyCaps = new HashMap<String, Capability>();
        dummyCaps.put("dummyCap", new Capability());
        dummyCaps.put("dummyCap", new Capability());
        dummyCaps.put("dummyCap", new Capability());

        final Node dummyNode = new Node();
        dummyNode.setCapabilities(dummyCaps);

        dummyNodes.put("dummyNode", dummyNode);
        dummyNodes.put("dummyNode", dummyNode);
        dummyNodes.put("dummyNode", dummyNode);


        final HashMap<String, Node> nodesI03 = new HashMap<String, Node>();

        final HashMap<String, Capability> capabilities_9112 = new HashMap<String, Capability>();
        capabilities_9112.put("urn:wisebed:node:capability:humidity", new Capability("urn:wisebed:node:capability:humidity", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x9112/capability/"));
        capabilities_9112.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x9112/capability/"));
        capabilities_9112.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x9112/capability/"));
        capabilities_9112.put("urn:wisebed:node:capability:ir", new Capability("urn:wisebed:node:capability:ir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x9112/capability/"));
        nodesI03.put("urn:wisebed:ctitestbed:0x9112", new Node("urn:wisebed:ctitestbed:0x9112", capabilities_9112, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x9112/"));


        final HashMap<String, Capability> capabilities_e852 = new HashMap<String, Capability>();
        capabilities_e852.put("urn:wisebed:node:capability:humidity", new Capability("urn:wisebed:node:capability:humidity", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xe852/capability/"));
        capabilities_e852.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xe852/capability/"));
        capabilities_e852.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xe852/capability/"));
        capabilities_e852.put("urn:wisebed:node:capability:ir", new Capability("urn:wisebed:node:capability:ir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xe852/capability/"));
        nodesI03.put("urn:wisebed:ctitestbed:0xe852", new Node("urn:wisebed:ctitestbed:0xe852", capabilities_e852, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0xe852/"));

        final HashMap<String, Capability> capabilities_585 = new HashMap<String, Capability>();
        capabilities_585.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x585/capability/"));
        capabilities_585.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x585/capability/"));
        capabilities_585.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x585/capability/"));
        nodesI03.put("urn:wisebed:ctitestbed:0x585", new Node("urn:wisebed:ctitestbed:0x585", capabilities_585, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x585/"));

        final HashMap<String, Capability> capabilities_786a = new HashMap<String, Capability>();
        capabilities_786a.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x786a/capability/"));
        capabilities_786a.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x786a/capability/"));
        capabilities_786a.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x786a/capability/"));
        nodesI03.put("urn:wisebed:ctitestbed:0x786a", new Node("urn:wisebed:ctitestbed:0x786a", capabilities_786a, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x786a/"));


        final HashMap<String, Capability> capabilities_842f = new HashMap<String, Capability>();
        capabilities_842f.put("urn:wisebed:node:capability:pir", new Capability("urn:wisebed:node:capability:pir", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:light4", new Capability("urn:wisebed:node:capability:light4", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:light", new Capability("urn:wisebed:node:capability:light", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:light2", new Capability("urn:wisebed:node:capability:light2", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:light3", new Capability("urn:wisebed:node:capability:light3", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:light1", new Capability("urn:wisebed:node:capability:light1", 0.0, true, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:co", new Capability("urn:wisebed:node:capability:co", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:ch4", new Capability("urn:wisebed:node:capability:ch4", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        capabilities_842f.put("urn:wisebed:node:capability:temperature", new Capability("urn:wisebed:node:capability:temperature", 0.0, false, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/capability/"));
        nodesI03.put("urn:wisebed:ctitestbed:0x842f", new Node("urn:wisebed:ctitestbed:0x842f", capabilities_842f, "http://uberdust.cti.gr/rest/testbed/1/node/urn:wisebed:ctitestbed:0x842f/"));

        rooms.put("0.I.3", new Room("0.I.3", nodesI03));
        //rooms.put("0.I.11", new Room("0.I.11", dummyNodes));


        insertNodesToCapabilities();

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

    public HashMap<String, Node> getNodesForRoomKey(final String roomKey) {
        return rooms.get(roomKey).getNodes();
    }

    public HashMap<String, Capability> getCapabilitiesForNodekey(final String roomKey, final String nodeKey) {

        return rooms.get(roomKey).getNodes().get(nodeKey).getCapabilities();
    }

    public Room getRoom(final String roomKey) {

        if (rooms.containsKey(roomKey)) {
            return rooms.get(roomKey);
        } else return null;

    }


    public void insertNodesToCapabilities() {
        for (String s : rooms.keySet()) {
            Log.d(TAG,"Room" + s);
            final Room room = rooms.get(s);
            final HashMap<String, Node> nodes = room.getNodes();

            for (Node node : nodes.values()) {
                final HashMap<String, Capability> caps = node.getCapabilities();
                for (Capability cap : caps.values()) {
                    cap.setNodeId(node.getId());
                }
            }

        }
    }
}

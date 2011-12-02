package com.uberKontroller.Storage;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Room {
    private String description;
    private HashMap<String, Node> nodes;

    public Room() {
        this.description = "desc";
        this.nodes = new HashMap<String, Node>();
    }

    public Room(final String description, final HashMap<String, Node> nodes) {
        this.description = description;
        this.nodes = nodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<String, Node> nodes) {
        this.nodes = nodes;
    }

    public HashMap<String, Capability> getCapabilitiesDEP() {
        final HashMap<String, Capability> capabilities = new HashMap<String, Capability>();
        for (Node node : nodes.values()) {
            final HashMap<String, Capability> nodeCaps = node.getCapabilities();
            for (String s : nodeCaps.keySet()) {
                capabilities.put(s, nodeCaps.get(s));
            }
        }
        return capabilities;


    }


}

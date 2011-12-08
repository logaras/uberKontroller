package com.uberKontroller.storage;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private String id;
    private HashMap<String, Capability> capabilities;
    private String URL;

    public Node() {
        id = "nodeId";
        URL = "http://restUrl";
        capabilities = new HashMap<String, Capability>();
    }

    public Node(final String id, final HashMap<String, Capability> capabilities, final String URL) {
        this.id = id;
        this.capabilities = capabilities;
        this.URL = URL;
    }

    public Node(final String id, final HashMap<String, Capability> capabilities) {
        this.id = id;
        this.capabilities = capabilities;
        this.URL = URL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(HashMap<String, Capability> capabilities) {
        this.capabilities = capabilities;
    }

}

package com.uberKontroller.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
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

}

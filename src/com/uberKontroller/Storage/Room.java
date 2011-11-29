package com.uberKontroller.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logaras
 * Date: 11/29/11
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Room {
    private String description;
    private List<Node> nodes;

    public Room() {
        this.description = "desc";
        this.nodes =  new ArrayList<Node>();
    }

    public Room(final String description, final List<Node> nodes){
        this.description = description;
        this.nodes = nodes;
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
}

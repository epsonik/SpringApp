package com.example.springapp.service;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Graph {
    private Map<String, LinkedHashSet<String>> graph = new HashMap<>();

    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = graph.get(node1);
        if (adjacent == null) {
            adjacent = new LinkedHashSet();
            graph.put(node1, adjacent);
        }
        adjacent.add(node2);
    }

    public LinkedHashSet<String> get(String nodeName) {
        return graph.get(nodeName);
    }

}

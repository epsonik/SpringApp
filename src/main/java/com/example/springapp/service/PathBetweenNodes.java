package com.example.springapp.service;

import java.util.*;

public class PathBetweenNodes {

    private Graph graph;
    private String START;
    private String END;
    private static boolean flag;
    private List<String> finalPath = new LinkedList<>();

    public PathBetweenNodes(Graph graph) {
        this.graph = graph;
    }

    public void setSTART(String START) {
        this.START = START;
    }

    public void setEND(String END) {
        this.END = END;
    }

    public List<String> getFinalPath() {
        return finalPath;
    }


    public List<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = graph.get(last);
        if (adjacent == null) {
            return new LinkedList();
        }
        return new LinkedList<>(adjacent);
    }


    void breadthFirst(PathBetweenNodes pathBetweenNodes,
                      LinkedList<String> visited) {
        List<String> nodes = pathBetweenNodes.adjacentNodes(visited.getLast());

        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                flag = true;
                finalPath = visited;
                return;
            }
        }

        for (String node : nodes) {

            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);

            breadthFirst(pathBetweenNodes, visited);
            if (flag) {
                return;
            }
            visited.removeLast();
        }

        if (flag == false) {
            flag = true;
            visited.removeLast();
        }
    }
}
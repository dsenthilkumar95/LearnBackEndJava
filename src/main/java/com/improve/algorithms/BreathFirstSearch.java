package com.improve.algorithms;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class BreathFirstSearch {
    private int nodeCount;
    private Node parentNode;
    private LinkedList<Integer>[] adjList;

    public void initNodes() {
        nodeCount = 5;
        Node node1 = new Node();
        node1.setValue("1");
        Node node2 = new Node();
        node2.setValue("2");
        Node node3 = new Node();
        node3.setValue("3");
        Node node4 = new Node();
        node4.setValue("4");
        Node node5 = new Node();
        node5.setValue("5");
        node1.setNodeList(Arrays.asList(node2,node3));
        node2.setNodeList(Arrays.asList(node4,node5));
        node3.setNodeList(Arrays.asList(node4,node5));
        parentNode = node1;
    }

    public List<String> retrieveAllNodesBFS() {
        Queue<Node> nodeQueue = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        List<String> out = new ArrayList<>();
        nodeQueue.add(parentNode);
        while(!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            visited.put(curr.getValue(),true);
            if(null != curr.getNodeList() && !curr.getNodeList().isEmpty()) {
                curr.getNodeList().forEach(node -> {
                    if(null == visited.get(node.getValue()) || visited.get(node.getValue()) == false) {
                        visited.put(node.getValue(), true);
                        nodeQueue.add(node);
                    }
                });
            }
        }
        return out.stream().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        BreathFirstSearch bfs = new BreathFirstSearch();
        bfs.initNodes();
        List<String> retrieveAllNodesBFSstringList = bfs.retrieveAllNodesBFS();
        System.out.println(Arrays.toString(retrieveAllNodesBFSstringList.toArray()));
    }
}

@Data
class Node {
    private String value;
    private List<Node> nodeList;
}

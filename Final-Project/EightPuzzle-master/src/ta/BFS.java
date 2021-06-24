/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA;

import java.util.*;

public class BFS {
    private Node root;
    private String goal;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public BFS(Node root, String goal) {
        this.root = root;
        this.goal = goal;
    }

    public void BreadthFirstSearch() {

        Set<String> state = new HashSet<String>();
        Node node = new Node(root.getState());
        Queue<Node> queue = new LinkedList<Node>();
        Node nodeSekarang = node;
        while (!nodeSekarang.getState().equals(goal)) {
            state.add(nodeSekarang.getState());
            List<String> nodeSuccessors = OperasiNode.getMove(nodeSekarang.getState());
            for (String n : nodeSuccessors) {
                if (state.contains(n))
                    continue;
                state.add(n);
                Node child = new Node(n);
                nodeSekarang.addChild(child);
                child.setParent(nodeSekarang);
                queue.add(child);

            }
            nodeSekarang = queue.poll();
        }

        OperasiNode.Solusi(nodeSekarang, state, root);

    }
}

package edu.interview_bit.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestDistanceBetweenNodesOfATree {

    int diameter = 0;

    class Node {

        int val;
        ArrayList<Node> children;

        Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 0, 0, 3};
        System.out.println(new LargestDistanceBetweenNodesOfATree().solve(A));
    }


    public int solve(int[] A) {
        if (A == null || A.length == 1 || A.length == 0) {
            return 0;
        }
        Node node = getTree(A);
        getTreeHeight(node);
        return diameter - 1;
    }

    private int getTreeHeight(Node node) {
        if (node.children.size() == 0) {
            return 1;
        }
        int maxHeight = 0;
        int secondMaxHeight = 0;
        for (Node n : node.children) {
            int h = getTreeHeight(n);
            if (maxHeight < h) {
                secondMaxHeight = maxHeight;
                maxHeight = h;
            } else if (secondMaxHeight < h) {
                secondMaxHeight = h;
            }

            if ((maxHeight + secondMaxHeight + 1) > diameter) {
                diameter = secondMaxHeight + maxHeight + 1;
            }
        }

        return maxHeight + 1;
    }

    private Node getTree(int[] A) {
        HashMap<Integer, Node> map = new HashMap<>();
        Node root = new Node(0);
        map.put(0, root);
        for (int i = 1; i < A.length; i++) {
            Node node = new Node(i);
            if (map.containsKey(A[i])) {
                map.get(A[i]).children.add(node);
            }
            map.put(i, node);
        }

        return root;
    }
}

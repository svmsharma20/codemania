package edu.interview_bit.graph;

import java.util.ArrayList;

public class PathInDirectedGraph {

    public int solve(int A, ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer>[] graph = getGraph(input, A);
        boolean[] visited = new boolean[A + 1];
        return isPathExist(graph, 1, A, visited);
    }

    public int isPathExist(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return 1;
        }

        visited[src] = true;
        for (Integer nebr : graph[src]) {
            if (!visited[nebr]) {
                int result = isPathExist(graph, nebr, dest, visited);
                if (result == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public ArrayList<Integer>[] getGraph(ArrayList<ArrayList<Integer>> input, int noOfNodes) {
        ArrayList<Integer>[] graph = new ArrayList[noOfNodes + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> l : input) {
            int src = l.get(0);
            int dest = l.get(1);
            graph[src].add(dest);
        }

        return graph;
    }
}

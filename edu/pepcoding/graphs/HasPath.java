package edu.pepcoding.graphs;

import edu.pepcoding.graphs.model.Edge;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HasPath {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<Edge>[] graph = new ArrayList[vtces];
    for (int i = 0; i < vtces; i++) {
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph[v1].add(new Edge(v1, v2, wt));
      graph[v2].add(new Edge(v2, v1, wt));
    }

    int src = Integer.parseInt(br.readLine());
    int dest = Integer.parseInt(br.readLine());

    boolean[] visited = new boolean[vtces];
    System.out.println(hasPath(graph, src, dest, visited));
  }

  public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

    visited[src] = true;
    if (src == dest) {
      return true;
    }

    for (Edge edge : graph[src]) {
      if (!visited[edge.nbr]) {
        boolean hasPathAvailable = hasPath(graph, edge.nbr, dest, visited);
        if (hasPathAvailable) {
          return true;
        }
      }
    }

    return false;
  }
}

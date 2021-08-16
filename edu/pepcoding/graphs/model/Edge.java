package edu.pepcoding.graphs.model;

public class Edge {

  public int src;
  public int nbr;
  public int wt;

  public Edge(int src, int nbr, int wt) {
    this.src = src;
    this.nbr = nbr;
    this.wt = wt;
  }
}

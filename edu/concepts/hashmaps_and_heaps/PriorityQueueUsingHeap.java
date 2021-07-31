package edu.concepts.hashmaps_and_heaps;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=RIjxT24gUv4&list=PL-Jc9J83PIiHq5rMZasunIR19QG3E-PAA&index=20
public class PriorityQueueUsingHeap {
  ArrayList<Integer> heap = new ArrayList<>();

  public void add(int data){
    heap.add(data);
    upheapify(size()-1);
  }

  private void upheapify(int ci) {
    if(ci == 0){
      return;
    }

    int pi = (ci - 1) / 2;
    if(heap.get(ci) < heap.get(pi)){
      swap(ci, pi);
      upheapify(pi);
    }
  }

  public Integer remove(){
    if(size()==0){
      return null;
    }

    int val = heap.get(0);
    swap(0, size()-1);
    heap.remove(size()-1);
    downheapify(0);
    return val;
  }

  private void downheapify(int pi) {
    int min = pi;

    int li = (2 * pi) + 1;
    if(li < size() && heap.get(li) < heap.get(min)){
      min = li;
    }

    int ri = (2 * pi) + 2;
    if(ri < size() && heap.get(ri) < heap.get(min)){
      min = ri;
    }

    if(min != pi){
      swap(min, pi);
      downheapify(min);
    }
  }

  public Integer peek(){
    if(size()==0){
      System.out.println("Underflow");
      return null;
    }
    return heap.get(0);
  }

  public int size(){
    return heap.size();
  }

  private void swap(int i, int j){
    int ith = heap.get(i);
    int jth = heap.get(j);
    heap.set(i, jth);
    heap.set(j, ith);
  }

  public static void main(String[] args) {
    PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap();

    pq.add(30);
    pq.add(50);
    pq.add(10);
    pq.add(90);
    pq.add(100);
    pq.add(20);
    pq.add(40);
    pq.add(120);
    pq.add(60);

    while(pq.size()>0) {
      System.out.println(pq.remove());
    }

  }
}

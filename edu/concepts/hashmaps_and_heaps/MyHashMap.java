package edu.concepts.hashmaps_and_heaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap <K, V>{
    class Node<K, V>{
      K key;
      V value;

      public Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    LinkedList<Node>[] buckets;
    int size = 0;

  public MyHashMap() {
    initbuckets(4);
    this.size = size;
  }

  private void initbuckets(int N) {
    buckets = new LinkedList[N];
    for (int i = 0; i < N; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  public void put(K key, V value){
    int bi = hashFunc(key);
    int di = getIndexInBucket(bi, key);

    if(di != -1){
      Node node = buckets[bi].get(di);
      node.value = value;
    }else{
      Node node = new Node(key, value);
      buckets[bi].add(node);
      size++;
    }

    double lambda = (size * 1.0) / buckets.length;
    if (lambda >= 2.0){
      rehash();
    }
  }

  private void rehash() {
    LinkedList<Node>[] oba = buckets;
    initbuckets(oba.length * 2);
    size = 0;

    for (int i = 0; i < oba.length; i++) {
      for (Node node : oba[i]) {
        put((K)node.key, (V)node.value);
      }
    }
  }

  public V get(K key){
    int bi = hashFunc(key);
    int di = getIndexInBucket(bi, key);

    if(di != -1){
      Node node = buckets[bi].get(di);
      return (V)node.value;
    }
    return null;
  }

  public boolean containsKey(K key){
    int bi = hashFunc(key);
    int di = getIndexInBucket(bi, key);

    if(di != -1){
      return true;
    }
    return false;
  }

  public V remove(K key){
    int bi = hashFunc(key);
    int di = getIndexInBucket(bi, key);

    if(di != -1){
      Node node = buckets[bi].remove(di);
      size--;
      return (V)node.value;
    }
    return null;
  }

  public ArrayList<K> keySet(){
    ArrayList<K> list = new ArrayList<>();

    for (int i = 0; i < buckets.length; i++) {
      for (Node node : buckets[i]){
        list.add((K)node.key);
      }
    }
    return list;
  }

  public int size(){
    return size;
  }

  private int hashFunc(K key){
    int hc = key.hashCode();
    return Math.abs(hc) % buckets.length;
  }

  private int getIndexInBucket(int bi, K key) {
    int di = 0;
    for (Node node: buckets[bi]) {
      if(node.key.equals(key)){
        return di;
      }
      di++;
    }
    return -1;
  }

  public static void main(String[] args) {
    MyHashMap<Integer, String> myMap = new MyHashMap<>();

    myMap.put(10, "TEN");
    myMap.put(1, "ONE");
    myMap.put(2, "TWO");
    myMap.put(20, "TWENTY");
    myMap.put(100, "HUNDRED");
    myMap.put(7, "SEVEN");

    System.out.println(myMap.size);

    System.out.println(myMap.keySet());

    for (Integer key : myMap.keySet()) {
      System.out.println(key + " - " + myMap.get(key));
    }

    myMap.remove(2);
    myMap.remove(20);
    myMap.remove(100);

    System.out.println("----------------After remove----------------");
    System.out.println(myMap.size);

    System.out.println(myMap.keySet());

    for (Integer key : myMap.keySet()) {
      System.out.println(key + " - " + myMap.get(key));
    }
  }

}

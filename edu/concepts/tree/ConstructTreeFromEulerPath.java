package edu.concepts.tree;

import java.util.ArrayList;
import java.util.Stack;

// https://www.pepcoding.com/resources/online-java-foundation/generic-tree/display-generic-tree/video

public class ConstructTreeFromEulerPath {

  private static class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int data) {
      this.data = data;
    }

    public void addChild(Node child){
      children.add(child);
    }
  }


  public static void main(String[] args) {
    int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120,
                    -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

    Stack<Node> stack = new Stack<Node>();
    Node root = new Node(-1);

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == -1){
        stack.pop();
      } else {
        Node node = new Node(arr[i]);
        if(stack.isEmpty()){
          root = node;
        }else{
          stack.peek().addChild(node);
        }
        stack.push(node);
      }
    }

    display(root);
  }

  public static void display(Node node){
    String str = node.data + " -> ";
    for (Node child: node.children) {
      str += child.data + ", ";
    }

    System.out.println(str);

    for (Node child: node.children) {
      display(child);
    }
  }
}

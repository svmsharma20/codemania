package edu.leetcode.linked_list;

public class CopyListWithRandomPointer {

  class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node start = head;
    // add a new node in between the original list nodes
    while (start != null) {
      Node node = new Node(start.val);
      node.next = start.next;
      start.next = node;
      start = node.next;
    }

    Node newHead = head.next;
    start = head;

    // correctly set the random pointer
    while (start != null) {
      if (start.random != null) {
        start.next.random = start.random.next;
      }
      start = start.next.next;
    }

    Node copyStart = newHead;
    start = head;

    // Separate original list from cloned list
    while (start != null) {
      start.next = copyStart.next;
      if (copyStart.next != null) {
        copyStart.next = copyStart.next.next;
      }
      start = start.next;
      copyStart = copyStart.next;
    }

    return newHead;
  }
}

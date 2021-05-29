package edu.concepts.linkedlist;

import java.util.Random;

public class LinkListUtility {
    
    public static ListNode createListWithRandomNumbers(int size){
        return createListWithRandomNumbers(size, -50, 51);
    }

    public static ListNode createListWithRandomNumbers(int size, int min, int max){
      Random rand = new Random();
      ListNode newNode = null;
      for (int i = 0; i < size; i++) {
        newNode = new ListNode(rand.nextInt(max - min) + min, newNode);
      }
      return newNode;
    }

    public static void printList(ListNode node){
        System.out.println();
         while(node!=null){
             System.out.print(node.val+" ");
             node = node.next;
         }
    }

    public static String getStringValue(ListNode node){
      String list = "[";
      while(node!=null){
        list += node.val+" ";
        node = node.next;
      }
      list += "]";
      return list;
    }

  public static ListNode reverse(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode prev = null;
    ListNode current = head;
    ListNode next = head.next;

    while(current!=null){
      current.next = prev;
      prev = current;
      current = next;
      next = next!=null ? next.next : next;
    }

    return prev;
  }
}

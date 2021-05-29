package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedList {

  public static void main(String[] args) {
    ListNode node7 = new ListNode(5, null);
    ListNode node6 = new ListNode(4, node7);
    ListNode node5 = new ListNode(4, node6);
    ListNode node4 = new ListNode(3, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head = node1;

    LinkListUtility.printList(head);
    LinkListUtility.printList(new RemoveDuplicatesFromSortedList().deleteDuplicates(head));
  }

  private ListNode deleteDuplicates(ListNode head) {

    ListNode prev = null;
    ListNode current = head;
    ListNode k = new ListNode(-1);
    ListNode newStart = k;

    while (current!=null){
      if(prev==null || current.val!=prev.val){
        k.next = current;
        k = k.next;
      }
      prev = current;
      current = current.next;
    }
    k.next = null;
    return newStart.next;
  }
}

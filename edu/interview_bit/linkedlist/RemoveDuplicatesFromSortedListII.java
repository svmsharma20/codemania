package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class RemoveDuplicatesFromSortedListII {

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
    LinkListUtility.printList(new RemoveDuplicatesFromSortedListII().deleteDuplicates(head));
  }

  public ListNode deleteDuplicates(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }
    ListNode start = new ListNode(-1);
    ListNode newHead = start;
    ListNode prevNode=null;
    ListNode currentNode = head;
    ListNode nextNode = currentNode.next;

    while (currentNode!=null){
      if(prevNode!=null && nextNode!=null){
        if(prevNode.val!=currentNode.val && currentNode.val!= nextNode.val){
          start.next = currentNode;
          start = start.next;
        }
      }else if(prevNode==null && nextNode!=null){
        if(currentNode.val!= nextNode.val){
          start.next = currentNode;
          start = start.next;
        }
      }else {
        if (prevNode.val != currentNode.val) {
          start.next = currentNode;
          start = start.next;
        }
      }
      prevNode = currentNode;
      currentNode = nextNode;
      nextNode = nextNode!=null? nextNode.next: null;
    }
    start.next = null;
    return newHead.next;
  }
}

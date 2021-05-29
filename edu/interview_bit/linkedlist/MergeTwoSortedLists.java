package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class MergeTwoSortedLists {

  public static void main(String[] args) {

    ListNode node5 = new ListNode(20, null);
    ListNode node4 = new ListNode(8, node5);
    ListNode node3 = new ListNode(8, node4);
    ListNode node2 = new ListNode(5, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head1 = node1;

    ListNode nodeE = new ListNode(15, null);
    ListNode nodeD = new ListNode(11, nodeE);
    ListNode nodeC = new ListNode(10, nodeD);
    ListNode nodeB = new ListNode(7, nodeC);
    ListNode nodeA = new ListNode(5, nodeB);
    ListNode head2 = nodeA;

    System.out.print("\nList A:");
    LinkListUtility.printList(head1);

    System.out.print("\nList B:");
    LinkListUtility.printList(head2);

    System.out.print("\nMerged Sorted List:");
    LinkListUtility.printList(new MergeTwoSortedLists().mergeTwoLists(head1, head2));
  }

  public ListNode mergeTwoLists(ListNode A, ListNode B) {
    ListNode start = new ListNode(-1);
    ListNode k = start;

    while (A!=null && B!=null){
      if(A.val< B.val){
        k.next = A;
        A = A.next;
      }else{
        k.next = B;
        B = B.next;
      }
      k = k.next;
    }

    if(A!=null){
      k.next = A;
    }else{
      k.next = B;
    }

    return start.next;
  }
}

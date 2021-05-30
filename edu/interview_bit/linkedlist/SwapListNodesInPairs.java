package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class SwapListNodesInPairs {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(9, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new SwapListNodesInPairs().swapPairs(head));
  }

  private ListNode swapPairs(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode i = head;
    ListNode j = head.next;
    ListNode newHead = new ListNode(-1);
    ListNode k = newHead;

    while (j!=null){
      k.next = j;
      i.next = j.next;
      j.next = i;
      k = i;
      i = i.next;
      j = i!=null ? i.next : null;
    }

    return newHead.next;
  }
}

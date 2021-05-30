package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class ReorderList {

  public ListNode reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast!=null && fast.next!=null && fast.next.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondHalfReversedHead = reverse(slow.next);
    slow.next = null;

    ListNode i = head;
    ListNode j = secondHalfReversedHead;
    ListNode k = new ListNode(-1);
    ListNode newHead = k;
    while(i!=null && j!=null){
      k.next = i;
      i = i.next;
      k = k.next;

      k.next = j;
      j = j.next;
      k = k.next;
    }

    if(i!=null){
      k.next = i;
    }

    if(j!=null){
      k.next = j;
    }

    return newHead.next;
  }

  public ListNode reverse(ListNode head){
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
      next = next!=null ? next.next : null;
    }

    return prev;
  }
}

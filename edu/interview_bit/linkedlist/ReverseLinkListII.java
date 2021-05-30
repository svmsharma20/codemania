package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class ReverseLinkListII {
  public ListNode reverseBetween(ListNode head, int B, int C) {
    ListNode start = new ListNode(-1);
    start.next = head;

    ListNode left = start;
    ListNode right = start;
    int count = 0;
    while(count!=C && right!=null){
      if(count<(B-1)){
        left = left.next;
      }
      right = right.next;
      count++;
    }

    ListNode temp = right.next;
    right.next = null;
    left.next = reverse(left.next);

    while(left.next!=null){
      left = left.next;
    }
    left.next = temp;

    return start.next;
  }

  public ListNode reverse(ListNode head){
    if(head==null || head.next==null){
      return head;
    }

    ListNode prev = null;
    ListNode current = head;
    ListNode next = current.next;
    while(current!=null){
      current.next = prev;
      prev = current;
      current = next;
      next = next!=null ? next.next : null;
    }

    return prev;
  }
}

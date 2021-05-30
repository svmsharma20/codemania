package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class ReverseAlternateKNodes {
  public ListNode solve(ListNode head, int B) {
    ListNode start = new ListNode(-1);
    start.next = head;
    ListNode left = start;
    ListNode right = start;
    while(right!=null){
      int count=0;
      //get the right end
      while(count!=B && right!=null){
        right = right.next;
        count++;
      }
      if(right==null){
        return start.next;
      }
      ListNode temp = right.next;
      right.next = null;
      //reverse the list
      left.next = reverse(left.next);
      while(left.next!=null){
        left = left.next;
      }
      left.next = temp;
      right = left;
      count=0;

      // skip the next B elements
      while(count!=B && right!=null){
        right = right.next;
        left = left.next;
        count++;
      }
    }
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

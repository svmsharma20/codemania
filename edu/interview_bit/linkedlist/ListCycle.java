package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class ListCycle {

  public ListNode detectCycle(ListNode head) {
    if(head==null || head.next==null || head.next.next==null){
      return null;
    }

    ListNode slow = head.next;
    ListNode fast = head.next.next;

    while(slow!=fast){
      if(fast==null || fast.next==null){
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    fast = head;

    while(slow!=fast){
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}

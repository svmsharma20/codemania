package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class KthNodeFromMiddle {
  public int solve(ListNode head, int B) {
    ListNode slow = head;
    ListNode fast = head;
    int count=0;
    while(fast!=null && fast.next!=null){
      if(count==B){
        slow = slow.next;
      }else{
        count++;
      }
      fast = fast.next.next;
    }

    if(count==B){
      return slow.val;
    }

    return -1;
  }
}

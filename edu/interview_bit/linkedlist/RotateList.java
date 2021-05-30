package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if(head==null || head.next==null){
      return head;
    }

    int len = 0;
    ListNode start = head;
    while(start!=null){
      start = start.next;
      len++;
    }

    int actualK = k%len;
    int count=0;

    ListNode i = head;
    ListNode j = head;
    while(i.next!=null){
      if(count==actualK){
        j = j.next;
      }else{
        count++;
      }
      i = i.next;
    }

    i.next = head;
    ListNode newHead = j.next;
    j.next = null;

    return newHead;
  }
}

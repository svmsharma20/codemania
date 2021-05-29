package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class RemoveNthNodeFromListEnd {
  public ListNode removeNthFromEnd(ListNode A, int B) {
    if(A==null || A.next==null){
      return null;
    }
    int count=0;
    ListNode i = A;
    ListNode j = A;

    while(i.next!=null){
      if(count==B){
        j = j.next;
      }else{
        count++;
      }
      i = i.next;
    }

    if(count<B){
      return A.next;
    }

    j.next = j.next.next;
    return A;
  }
}

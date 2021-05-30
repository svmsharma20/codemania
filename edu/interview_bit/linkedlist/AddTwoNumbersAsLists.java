package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class AddTwoNumbersAsLists {

  public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
    ListNode i = h1;
    ListNode j = h2;
    ListNode sumList = new ListNode(-1);
    ListNode k = sumList;

    int carry = 0;
    while(i!=null && j!=null){
      int sum = i.val + j.val + carry;
      carry = sum/10;
      ListNode newNode = new ListNode(sum%10);
      k.next = newNode;
      k = k.next;

      i = i.next;
      j = j.next;
    }

    while(i!=null){
      int sum = i.val + carry;
      carry = sum/10;
      ListNode newNode = new ListNode(sum%10);
      k.next = newNode;
      k = k.next;
      i = i.next;
    }

    while(j!=null){
      int sum = j.val + carry;
      carry = sum/10;
      ListNode newNode = new ListNode(sum%10);
      k.next = newNode;
      k = k.next;
      j = j.next;
    }

    if(carry!=0){
      k.next = new ListNode(carry);
    }

    return sumList.next;
  }

}

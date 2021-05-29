package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class EvenReverse {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(9, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new EvenReverse().solve(head));
  }

  public ListNode solve(ListNode head) {
    ListNode oddPlacesHead = head;
    ListNode i = head;

    ListNode evenPlacesHead = head.next;
    ListNode j = head.next;

    while(i!=null && j!=null){
      i.next = j.next;
      i = i.next;
      if(i!=null){
        j.next = i.next;
        j = j.next;
      }
    }

    ListNode evenListReversed =  LinkListUtility.reverse(evenPlacesHead);
    i = oddPlacesHead;
    j = evenListReversed;
    ListNode k = new ListNode(-1);
    ListNode newHead = k;

    while (i!=null && j !=null){
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
}

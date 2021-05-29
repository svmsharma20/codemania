package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class SortList {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(10, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new SortList().sortList(head));
  }

  private ListNode sortList(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode startOfSecondHalfList = divideList(head);

    ListNode i = sortList(head);
    ListNode j = sortList(startOfSecondHalfList);

    ListNode k = new ListNode(-1);
    ListNode start = k;

    while (i!=null && j!=null){
      if(i.val<=j.val){
        k.next = i;
        i = i.next;
      }else{
        k.next = j;
        j = j.next;
      }
      k = k.next;
    }

    if(i!=null){
      k.next = i;
    }else {
      k.next = j;
    }

    return start.next;
  }

  private ListNode divideList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next!=null && fast.next.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode startofSecondHalf = slow.next;
    slow.next = null;

    return startofSecondHalf;
  }
}

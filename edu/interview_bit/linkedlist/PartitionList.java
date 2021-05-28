package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class PartitionList {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(10, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(partition(head, 3));
  }

  private static ListNode partition(ListNode head, int x) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode smallerList = new ListNode(-1);
    ListNode smallerHead = smallerList;
    ListNode greaterList = new ListNode(-1);
    ListNode greaterHead = greaterList;
    ListNode start = head;

    while(start!=null){
      if(start.val<x){
        smallerList.next = start;
        smallerList = smallerList.next;
      }else{
        greaterList.next = start;
        greaterList = greaterList.next;
      }
      start = start.next;
    }
    greaterList.next = null;

    if(smallerHead.next!=null){
      smallerList.next = greaterHead.next;
    }else {
      smallerHead = greaterHead;
    }
    head = smallerHead.next;
    return head;
  }

}

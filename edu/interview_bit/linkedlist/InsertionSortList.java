package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class InsertionSortList {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(10, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new InsertionSortList().sort(head));
  }

  /*By interchanging nodes*/
  private ListNode sort(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode start = new ListNode(-1, head);
    ListNode index = head.next;

    while(index!=null){
      ListNode current = index;
      index = index.next;
      ListNode i = start;
      while (i.next!= current && i.next.val<=current.val){
        i = i.next;
      }
      if(i.next==head){
        while (i.next!=current){
          i = i.next;
        }
        i.next = index;
        current.next = head;
        head = current;
        start.next = current;
      }else if(i.next!=current){
        current.next = i.next;
        i.next = current;
        i=current;
        while (i.next!=current){
          i = i.next;
        }
        i.next = index;
      }
    }
    head = start.next;
    return head;
  }

  /*By interchanging values*/
  public ListNode insertionSortList(ListNode A) {
    if(A==null||A.next==null) return A;
    ListNode insert,current=A.next;
    while(current!=null){
      insert=A;
      while(insert!=current){
        if(insert.val<current.val) insert=insert.next;
        else{
          int temp=current.val;
          current.val=insert.val;
          insert.val=temp;
        }
      }
      current=current.next;
    }
    return A;
  }
}

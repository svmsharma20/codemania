package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class SortBinaryLinkedList {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(10, 0, 2);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new SortBinaryLinkedList().solve(head));
  }

  public ListNode solve(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode j = head;

    /*
    * We starting from second node and leaving out the first node
    * Because the value of the first node will not affect the algorithm.
    * */
    ListNode i = head.next;

    while (i!=null){
      if(i.val==0){
        j.next = i.next;
        i.next = head;
        head = i;
        i = j.next;
      }else {
        i = i!=null ? i.next : null;
        j = j!=null ? j.next : null;
      }
    }

    return head;
  }
}

package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.LinkListUtility;
import edu.concepts.linkedlist.ListNode;

public class KReverseLinkedList {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(10, 1, 11);
    LinkListUtility.printList(head);
    int K = 3;
    LinkListUtility.printList(new KReverseLinkedList().reverseList(head, K));
  }

  private ListNode reverseList(ListNode head, int k) {
    int count=1;
    ListNode left = head;
    ListNode right = head;
    ListNode newHead = null;
    ListNode i = null;

    while(right!=null){
       if(count<k && right.next!=null){
         right = right.next;
         count++;
       }else{
         count=1;
         ListNode temp = right.next;
         right.next = null;

         if(newHead==null){
           newHead = reverse(left);
           i = newHead;
         }else{
           i.next = reverse(left);
         }
         while (i.next!=null){
           i = i.next;
         }

         left = right = temp;
       }
    }
    return newHead;
  }

  private ListNode reverse(ListNode head) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode prev = null;
    ListNode current = head;
    ListNode next = head.next;

    while(current!=null){
      current.next = prev;
      prev = current;
      current = next;
      next = next!=null ? next.next : next;
    }

    return prev;
  }
}

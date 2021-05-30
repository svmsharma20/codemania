package edu.concepts.linkedlist;

public class SwapEvenPlacesNodes {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(7, 1, 11);
    LinkListUtility.printList(head);
    LinkListUtility.printList(new SwapEvenPlacesNodes().solve(head));
  }

  public ListNode solve(ListNode head) {
    if(head==null || head.next==null || head.next.next==null || head.next.next.next==null){
      return head;
    }

    ListNode pointer1 = head;
    ListNode pointer2 = head.next.next;
    int count=4;

    while (pointer2 != null && pointer2.next!=null){
      if(count==4){
        ListNode temp1 = pointer2.next.next;
        ListNode temp2 = pointer2.next;
        pointer2.next.next = pointer2;
        pointer2.next = pointer1.next;
        pointer1.next.next = temp1;
        pointer1.next = temp2;
        count = 0;
      }else{
        pointer1 = pointer1.next;
        pointer2 = pointer2.next;
        count++;
      }
    }

    return head;
  }
}

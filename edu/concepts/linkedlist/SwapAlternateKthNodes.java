package edu.concepts.linkedlist;

public class SwapAlternateKthNodes {

  public static void main(String[] args) {
    ListNode head = LinkListUtility.createListWithRandomNumbers(20, 1, 101);
    int B = 4;
    LinkListUtility.printList(head);
    LinkListUtility.printList(new SwapAlternateKthNodes().solve(head, B));
  }

  public ListNode solve(ListNode head, int B) {
    if(head==null || head.next==null){
      return head;
    }

    ListNode i = new ListNode(-1);
    i.next = head;
    ListNode j = i;
    ListNode newHead = i;
    int count=1;

    while(count!=B && j!=null){
      j = j.next;
      count++;
    }

    while(j!=null && j.next!=null){
      swap(i, j, B);
      count=0;
      while(count!=(B*2) && j!=null){
        i = i.next;
        j = j.next;
        count++;
      }
      if(B==2){
        j = i.next;
      }
    }

    return newHead.next;
  }

  public void swap(ListNode i, ListNode j, int B){
    if(B==2){
      ListNode temp1 = j.next.next;
      ListNode temp2 = j.next;
      j.next = temp1;
      temp2.next = j;
      i.next = temp2;
    }else{
      ListNode temp1 = j.next.next;
      ListNode temp2 = j.next;
      j.next.next = i.next.next;
      i.next.next = temp1;
      j.next = i.next;
      i.next = temp2;
    }

  }
}

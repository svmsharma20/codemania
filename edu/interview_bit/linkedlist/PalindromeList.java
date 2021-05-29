package edu.interview_bit.linkedlist;

import edu.concepts.linkedlist.ListNode;

public class PalindromeList {

  /*
  * 1 for Palindrome
  * 0 for Not palindrome
  * */
  int ans = 1;

  public static void main(String[] args) {
    /* testcase for odd numbers of elements*/
    ListNode node5 = new ListNode(1, null);
    ListNode node4 = new ListNode(2, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);
    ListNode head = node1;

    PalindromeList test1 = new PalindromeList();
    test1.computeIsPalindrome(head, head);
    System.out.println(test1.ans);



    /*testcase for even number of elements*/
    ListNode nodeD = new ListNode(1, null);
    ListNode nodeC = new ListNode(3, nodeD);
    ListNode nodeB = new ListNode(3, nodeC);
    ListNode nodeA = new ListNode(1, nodeB);
    ListNode head2 = nodeA;

    PalindromeList test2 = new PalindromeList();
    test2.computeIsPalindrome(head2, head2);
    System.out.println(test2.ans);

  }

  /*Using recursion: didn't modify the list
  * For other approach refer Complete Solution on interview bit
  * https://www.interviewbit.com/problems/palindrome-list/
  * */
  private ListNode computeIsPalindrome(ListNode slow, ListNode fast) {
    if(fast.next==null){
      // List has odd number of elements
      fast = slow;
      return fast.next;
    }
    if(fast.next.next==null){
      // List has even number of elements
      fast = slow.next;
      if(slow.val==fast.val){
        return fast.next;
      }else{
        ans=0;
        return null;
      }
    }

    ListNode newFastNode = computeIsPalindrome(slow.next, fast.next.next);
    if(newFastNode==null){
      ans = 0;
      return null;
    }

    if(slow.val == newFastNode.val){
      return newFastNode.next;
    }
    ans=0;
    return null;
  }
}

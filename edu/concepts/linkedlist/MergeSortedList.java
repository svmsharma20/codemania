package edu.concepts.linkedlist;

import static edu.concepts.linkedlist.LinkListUtility.printList;
import static edu.concepts.linkedlist.LinkListUtility.createListWithRandomNumbers;;

public class MergeSortedList {

    //  https://leetcode.com/problems/sort-list/solution/

    ListNode nextSubList = new ListNode();
    ListNode tail = new ListNode();
    public static void main(String[] args) {
        ListNode head = createListWithRandomNumbers(10);
        printList(head);
        MergeSortedList mergeSort = new MergeSortedList();
        mergeSort.getSize(head);
        
        printList(mergeSort.sortList(head));
    }

    ListNode sortList(ListNode head){

        if(head == null || head.next==null){
            return head;
        }

        int n = getSize(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();

        for (int i = 1; i < n; i = i*2) {
            tail = dummyHead;
            while(start!=null){
                if(start.next==null){
                    tail.next = start;
                    break;
                }
                
                ListNode mid = split(start, i);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        
        return dummyHead.next;
    }


    ListNode split(ListNode node, int size){

        ListNode fast = node.next;
        ListNode slow = node;

        for (int i = 1; i < size && ((slow !=null && slow.next!=null) || (fast!=null && fast.next!=null)); i++) {
            if(fast.next!=null){
                fast = (fast.next.next!=null) ? fast.next.next : fast.next;
            }
            slow = slow.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        nextSubList = fast.next;
        fast.next= null;
        return mid;
    }
   
    void merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode();
        
        ListNode dummy = dummyHead;
        while(l1!=null && l2!=null){
            if(l1.val<= l2.val){
               dummy.next = l1;
               l1 = l1.next;
            }else{
               dummy.next = l2;
               l2 = l2.next;
            }
            dummy = dummy.next;
        }

        dummy.next = (l1!=null) ? l1 : l2;

        while(dummy!=null && dummy.next!=null){
            dummy = dummy.next;
        }
        tail.next = dummyHead.next;
        // newTail.next = dummy.next;
        // newTail = dummy;
        tail = dummy;
    }

    int getSize(ListNode node){
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }

        return size;
    }
}

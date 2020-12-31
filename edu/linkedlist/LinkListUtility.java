package edu.linkedlist;

import java.util.Random;

public class LinkListUtility {
    
    static ListNode createListWithRandomNumbers(int size){
        Random rand = new Random();
        ListNode newNode = null;
        for (int i = 0; i < size; i++) {
            newNode = new ListNode(rand.nextInt(100)-50, newNode);
        }
        return newNode;
    }
    
    static void printList(ListNode node){
        System.out.println();
         while(node!=null){
             System.out.print(node.val+" ");
             node = node.next;
         }
     }
}

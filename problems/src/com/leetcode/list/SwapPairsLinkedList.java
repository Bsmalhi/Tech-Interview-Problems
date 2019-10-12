package com.leetcode.list;

import com.list.LinkedList;
import com.list.ListNode;

import java.util.List;

public class SwapPairsLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode sampleList = list.insertDummyValue(List.of(1,2,3,4,5,6));
        list.printList(sampleList);
        System.out.println();
        ListNode result = swapPairsRecursive(sampleList);
        list.printList(result);
    }

    private static ListNode swapPairsRecursive(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairsRecursive(head.next.next);
        newHead.next = head;
        return newHead;
    }

    public static ListNode swapPairs(ListNode head){
        ListNode curr = head, newHead = head.next;
        while(curr != null && curr.next != null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
            if(curr != null && curr.next != null)
                temp.next = curr.next;
        }
        return newHead;
    }

}

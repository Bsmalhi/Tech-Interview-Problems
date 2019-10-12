package com.leetcode.list;

import com.list.LinkedList;
import com.list.ListNode;

import java.util.List;

public class mergeTwoSortedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList l3 = new LinkedList();
        ListNode list1 = l1.insertDummyValue(List.of(1,3,5));
        l1.printList(list1);
        System.out.println();
        ListNode list2 = l2.insertDummyValue(List.of(2,4,6));
        l2.printList(list2);
        System.out.println();
        ListNode result = mergeTwoLists2(list1, list2);
        l3.printList(result);
//        while(result != null){
//            System.out.print( result.val +" ");
//            result = result.next;
//        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return head.next;
    }
}

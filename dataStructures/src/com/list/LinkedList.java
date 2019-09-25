package com.list;

import java.util.List;

public class LinkedList {

    ListNode head = null, tail = null;

    public void insert(int val){
        if(this.head == null){
            head = new ListNode(val);
            tail = head;
        }else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }
    public void printList(){
        ListNode curr = head;
        while(curr != null){
            if(curr.next != null)
                System.out.print( curr.val+ " -> ");
            else
                System.out.print( curr.val);
            curr = curr.next;
        }
    }

    public void swapPairs(){
        ListNode curr = head;
        while(curr != null && curr.next != null){
            ListNode temp = curr;
            curr = curr.next;


        }
    }

    public void insertDummyValue(List<Integer> integers) {
        integers.stream().forEach(this::insert);
    }
}

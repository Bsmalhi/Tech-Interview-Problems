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

    public ListNode insertDummyValue(List<Integer> integers) {
        integers.stream().forEach(this::insert);
        return head;
    }

    public void printList(ListNode result) {
        ListNode curr = result;
        while(curr != null){
            if(curr.next != null)
                System.out.print( curr.val+ " -> ");
            else
                System.out.print( curr.val);
            curr = curr.next;
        }
    }
}

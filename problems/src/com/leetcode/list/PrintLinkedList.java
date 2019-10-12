package com.leetcode.list;

import com.list.LinkedList;

public class PrintLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(5);
        list.insert(11);
        list.insert(12);
        list.printList();
    }
}

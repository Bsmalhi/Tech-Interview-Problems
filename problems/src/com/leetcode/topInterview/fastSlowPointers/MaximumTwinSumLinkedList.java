class MaximumTwinSumLinkedList{
    public int pairSum(ListNode head) {
      ListNode slow = head, fast = head;
      // find middle of linked list
      while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }
      // reverse list starting from middle
      ListNode curr = slow, prev = null;
      while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      // add pairs of list1 and list2
      curr = prev;
      ListNode curr2 = head;
      int max;
      while(curr != null && curr2 != null){
        max = Math.max(max, curr.val + curr2.val);
        curr = curr.next;
        curr2 = curr2.next;
      }
      return max;
    }
}

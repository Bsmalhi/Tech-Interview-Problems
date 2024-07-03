class DeleteNthNodeInList{
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode curr = head, dummy = new ListNode(0);
      dummy.next = head;
      while(curr != null && n > 0){
          curr = curr.next;
          n--;
      }
      // found the count now shift pointer of n - 1 node to n.next node to delete nth node
      ListNode left = dummy;
      while(curr !=  null){
          curr = curr.next;
          left = left.next;
      }
      left.next = left.next.next;
      return dummy.next;
  }
}

public class LinkedListCycleII {
  // Lyods algorithm of Tortoise and Hare is used here to detect starting of node cycle
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, curr = head;
        while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
          if(fast == slow)
            break;
        }
      // check is no cycle
      if(fast == null || fast.next == null)
        return null;
      // detect the starting of the cycle
      while(curr != slow){
        curr = curr.next;
        slow = slow.next;
      }
      return curr;
    }
}

class AddTwoNumbers{
  /*
  You are given two non-empty linked lists representing two non-negative integers.
  The digits are stored in reverse order, and each of their nodes contains a single digit. 
  Add the two numbers and return the sum as a linked list.
  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  Input: l1 = [2,4,3], l2 = [5,6,4]
  Output: [7,0,8]
  Explanation: 342 + 465 = 807.
  */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode curr = new ListNode(0);
    ListNode head = curr;
    int carry = 0;
    
    while(l1 != null || l2 != null){
      int l1val = l1 == null ? 0 : l1.val;
      int l2val = l2 == null ? 0 : l2.val;
      int sum = l1val + l2val + carry;
      carry = sum / 10;
      curr.next = new ListNode(sum % 10 );
      curr = curr.next;
      if( l1.next != null)
        l1 = l1.next;
      if(l2.next != null)
        l2 = l2.next;
    }
    if( carry != 0)
      curr.next = new ListNode(carry);
    
      return head.next;
  }
}

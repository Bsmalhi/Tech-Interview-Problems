/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ReverseKLists {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, newHead = null, kTail = null;
        while( curr != null ){
            int count = 0;
            // this is just to check if list has k nodes to reverse
            while(count < k && curr != null){
                curr = curr.next;
                count++;
            }
            if(count == k){
                ListNode reverseHeadList = reverseList(head, k);
                if(newHead == null)
                    newHead = reverseHeadList;
                if(kTail != null)
                    kTail.next = reverseHeadList;
                kTail = head;
                head = curr;
            }
        }
        // if Ktail couldn't be reversed than leave it as such without reversing the list
        if(kTail != null){
            kTail.next = head; 
        }
        return newHead != null ? newHead: head;
    }
    private ListNode reverseList(ListNode head, int k){
        ListNode curr = head;
        ListNode prev = null;
        while(k > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }
        return prev;
    }
}

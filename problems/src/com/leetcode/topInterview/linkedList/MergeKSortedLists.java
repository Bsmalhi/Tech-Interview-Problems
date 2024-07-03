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

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int interval = 1, size = lists.length;
        while( interval < size){
            // merge the i and i + interval into i
            for(int i = 0; i < size - interval; i += 2*interval ){ 
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            } else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null)
            curr.next = l1;
        if(l2 != null)
            curr.next = l2;
        return head.next;
    }
}

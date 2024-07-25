/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class InsertIntoCircularLinkedList {
    /**
     Insert into circular linked list sorted in ascending order 
     given node can be a Reference to any node in list 
     if multiple places for insertion you may choose any place to insert the new value
     we have to return circular list in ascending order
     problem can have 2 test cases 
        // case 1: 1 <- node.val(2) <- 3
            if(prev.val <= insertVal &&  insertVal <= curr.val){
        //case 2: 3 -> 1, 3 -> node.val(4) -> 1
            if(prev.val > curr.val && (insertVal > prev.val || insertVal < curr.val))
     */
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        } 
        Node prev = head, curr = head.next;
        while(prev.next != head){
            // case 1: 1 <- node.val(2) <- 3
            if(prev.val <= insertVal &&  insertVal <= curr.val){
                break;
            }
            //case 2: 3 -> 1, 3 -> node.val(4) -> 1
            if(prev.val > curr.val && (insertVal > prev.val || insertVal < curr.val))
                break;
            prev = prev.next;
            curr = curr.next;
        }
        Node node = new Node(insertVal);
        prev.next = node;
        node.next = curr;
        return head;  
    }
}

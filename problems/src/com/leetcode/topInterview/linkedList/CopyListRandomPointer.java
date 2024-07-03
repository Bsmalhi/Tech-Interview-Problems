class CopyListRandomPointer{
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node curr = head;
        Map<Node, Node> copyMap = new HashMap<>(); // to store copy of original map
        while(curr != null){
            copyMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node copy = new Node(0);
        while(curr != null){
            copy = copyMap.get(curr);
            copy.random = copyMap.get(curr.random);
            copy.next = copyMap.get(curr.next);
            curr = curr.next;
        }
        return copyMap.get(head);
    }
}

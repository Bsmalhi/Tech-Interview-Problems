/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class BSTintoCircularDoubleLinkedList {
    Node first;
    Node last;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return root;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }
    // in order traversal go left -> root -> right
    private void helper(Node node){
        if(node == null)
            return;
        // point to left
        helper(node.left);
        if(last != null){
            last.right = node; // last.right -> currNode
            node.left = last;
        } else {
            first = node;
        }
        last = node; // update last to be current node
        helper(node.right);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/**
Given a perfect Binary Tree
 */
class PopulatingNextRightPointerBST {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
              // we ensure that not to establish next pointer beyond end of level
              if(i < size - 1)
                  temp.next = queue.peek(); // which will give you the right element
              if(temp.left != null)
                queue.offer(temp.left);
              if(temp.right != null)
                queue.offer(temp.right);
            }
        }
      return root;
    }
}

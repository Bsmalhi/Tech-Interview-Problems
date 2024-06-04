class InorderBST{
  class Node{
    int val;
    Node left, right;
    public Node(int val){
      this.val = val;
    }
  }
  //Use a stack and if curr != null then print
  // time and space complexity O(n)
  public void iterativeInorderTraversal(Node root){
      Stack<Node> stack = new Stack<>();
    Node curr = root;
      while(curr != null || !stack.isEmpty()){
     if(curr != null){
       stack.push(curr);
       curr = curr.left;
     } else {
       curr = stack.pop();
       System.out.print(curr.val);
       curr = curr.right;
     }
    }
  }
  public void iterativePreorderTraversal(Node root){
      Stack<Node> stack = new Stack<>();
      Node curr = root;
      while(curr != null || !stack.isEmpty()){
        if(curr != null) {
          System.out.println(curr.val);
          if(curr.right != null)
            stack.push(curr.right);
          curr = curr.left;
        } else {
          curr = stack.pop();
        }
    }
  }
  public void iterativePostorderTraversal(Node root){
    Stack<Node> stack = new Stack<>();
    Stack<Boolean> visit = new Stack<>();
      stack.push(root);
    visit.push(False);
    while(!stack.isEmpty() || !visited.isEmpty()){
      Node curr = stack.pop();
      boolean visited = visited.pop();
      if(curr != null){
        if(visited){
          System.out.print(curr.val);
        }
        else {
          stack.push(curr);
          visit.push(true);
          stack.push(curr.right);
          visit.push(false;
          stack.push(curr.left);
          visit.push(false);
      }
    }
  }
  }
}







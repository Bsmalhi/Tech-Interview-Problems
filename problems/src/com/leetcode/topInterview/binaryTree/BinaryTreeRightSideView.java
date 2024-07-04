class BinaryTreeRightSideView{
      public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
          queue.add(root);
        while(!queue.isEmpty()){
          int size = queue.size();
          for(int i = 0; i < size; i++){
            TreeNode curr = queue.poll();
            if(i == 0){
              res.add(curr.val);
            }
            if(curr.right != null) // right is poped first so i == 0 breadth level order traversal helps in this
              queue.offer(curr.right);
            if(curr.left != null)
              queue.offer(curr.left);
          }
        }
        return res;
      }
}
      

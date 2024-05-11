class BinaryTreeLevelOrderTraversal{

  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        LinkedList<TreeNode> queue = new LinkedList();
        if(root != null){
          queue.offer(root);
        }
        while(!queue.isEmpty()){
          int size = queue.size();
          List<Integer> list = new ArrayList<>();
          for(int i = 0; i < size; i++){
            TreeNode curr = queue.poll();
            list.add(curr.val);
            if(curr.left != null)
              queue.add(curr.left);
            if(curr.right != null)
              queue.add(curr.right);
          }
          result.add(list);
        }
    return res;
}

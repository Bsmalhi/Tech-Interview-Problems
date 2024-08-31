class MergeTwoBinaryTree {
    /**
    Given 2 binary trees root1 & root2 return merged tree.
    Note: some nodes of the two trees are overlapped while the others are not. 
    You need to merge the two trees into a new binary tree. 
    The merge rule is that if two nodes overlap, then sum node values 
    up as the new value of the merged node.
     */
  // here we are merge root2 into root1
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
      if(root1 == null)
        return roo1;
      if(root2 == null)
        return root2;
      root1.val += root2.val; // if they overlap add root2 val into root1 val
      root1.left = mergeTrees(root1.left, root2.left);
      root2.right = mergeTees(root1.right, root2.right);
      return root1;
    }
}

class DiameterOfBinaryTree{
  // basically calculate max depth of left and right nodes 
  // then to find max diameter just add max = max(leftDepth + rightDepth) will give the diameter

  int max;
  public in diameter(TreeNode root){
    max = 0;
    dfs(root);
    return max;
  }
  private int dfs(TreeNode root){
    if(root == null)
      return 0;
    if(root.left == null && root.right == null)
      return 1;
    int left = dfs(root.left);
    int right = dfs(root.right);

    max = Math.max(max, left + right);

    return 1 + Math.max(left, right);
  }
}

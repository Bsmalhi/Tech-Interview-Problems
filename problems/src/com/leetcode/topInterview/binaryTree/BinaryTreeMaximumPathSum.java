class BinaryTreeMaximumPathSum{
  // most of the points are mentioned in the problem itself try to read to understand
  int maxSum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root){
    dfs(root);
    return maxSum;
  }
  private int dfs(TreeNode root){
    if(root == null)
      return 0;
    int left = Math.max(dfs(root.left), 0);
    int right = Math.max(dfs(root.right), 0);
    int currentPathSum = root.val + left + right; // include current node val and left + right
    maxSum = Math.max(maxSum, currentPathSum);

    return root.val + Math.max(left, right); // only include root.val and left or right max
  }
}

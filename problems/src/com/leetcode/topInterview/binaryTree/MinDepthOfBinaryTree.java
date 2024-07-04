class MinDepthOfBinaryTree{
  // bottom up approach meaning step recursively to the leaf nodes
  // and calculate depth back up to root
  public int minDepth(TreeNode root){
    if(root == null)
      return Integer.MAX_VALUE;
    if(root.left == null && root.right == null)
      return 1;
    int left = dfs(root.left);
    int right = dfs(root.right);
    return 1 + Math.min(left, right);
  }

  // top down approach passes information from root nodes down to the child nodes
  public int minDepth(TreeNode root){
    return dfs(root, 1);
  }
  private int dfs(TreeNode root, int depth){
    if(root == null) // this means subtract the depth from null node
      return depth - 1;
    if(root.right == null && root.left == null) // leaf node count as 1 depth
      return depth;
    int left = dfs(root.left, depth + 1);
    int right = dfs(root.right, depth + 1);
    return math.min(left, right);
  }
}

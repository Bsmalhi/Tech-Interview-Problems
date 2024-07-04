class CountGoodNodes{
  // criteria for goodNode is that root.val < nodeX.val
  public int goodNodes(TreeNode root){
    return goodNodes(root, root.val);
  }
  private int goodNodes(TreeNode root, int maxVal){
    if(root == null)
      return 0;
    int count = 0;
    if(root.val >= maxVal){
      count = 1;
      maxVal = root.val;
    }
    count += goodNodes(root.left, maxVal);
    count += goodNodes(root.right, maxVal);

    return count;
  }
}

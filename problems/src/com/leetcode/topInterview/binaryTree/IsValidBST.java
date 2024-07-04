class IsValidBST {
    // valid BST return if possible
    // left.val < root && root.val < right.val
    public boolean isValidBST(TreeNode root) {
     return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }
  private boolean isValidBST(TreeNode root, int min, int max){
    if(root == null)
      return true;
    if(!(min < root.val && root.val < max)) // invalidates BST principles
        return false;
    return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
  }
}

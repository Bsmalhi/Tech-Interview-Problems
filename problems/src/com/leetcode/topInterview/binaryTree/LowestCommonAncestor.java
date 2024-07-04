class LowestCommonAncestor{
  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
    if(p.val < root.val && q.val < root.val){ // recurse left if p & q < root.val
      return lowestCommonAncestor(root.left, p, q);
    } else if(p.val > root.val && q.val > root.val){ // recurse right if p & q > root.val
      return lowestCommonAncestor(root.right, p, q);
    }
    return root; // otherwise root is the lowest common ancestor
  }
  
  public TreeNode lowestCommonAncestorBottomUp(TreeNode root, TreeNode p, TreeNode q) {
    // base case where we found p or q equals to root or root is null return root
    if(root == null || p.val == root.val || q.val == root.val){
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q); // recurse left
    TreeNode right = lowestCommonAncestor(root.right, p, q); // recurse right

    if(left != null && right != null) // if both left & right are not null
      return root;
    
    return left != null ? left : right; // if only one of left or right is null check and return resp.
  }
}

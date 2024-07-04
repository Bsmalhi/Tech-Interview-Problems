class BSTUsingPreOrderAndInorder{
  int preIndex = 0;
  Map<Integer, Integer> map = HashMap<>();
  public TreeNode buildTree(int[] preorder, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0 , inorder.length - 1, inorder);
  }
  private TreeNode build(int[] preorder, int start, int end, int[] inorder){
    if(start > end) return null;
    TreeNode root = new TreeNode(preorder[preIndex++]);
    int inorderIndex = map.get(root.val);
    root.left = build(preorder, start, inorderIndex - 1, inorder);
    root.right = build(preorder, inorderIndex + 1, end, inorder);
  
    return root;
  }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    private Pair dfs(TreeNode root){
      if(root == null)
        return new Pair(true, 0);
      Pair left = dfs(root.left);
      Pair right = dfs(root.right);

      boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left - right) < 2;
      return new Pair(isBalanced, Math.max(left.height, right.height) + 1);
    }
    class Pair{
      boolean isBalanced;
      int height;
      public Pair(boolean isBalanced, int height){
        this.isBalanced = isBalanced;
        this.height = height;
      }
    }
}

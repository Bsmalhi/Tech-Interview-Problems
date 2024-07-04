class MaxDepthOfBST {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root == null)
            return 0;
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}

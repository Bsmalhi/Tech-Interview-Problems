class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        targetSum -= root.val;
        if( targetSum == 0 && root.left == null && root.right == null) // edge case leaf Node found and targetSum matched
            return true;
        if(hasPathSum(root.left, targetSum))
            return true;
        if(hasPathSum(root.right, targetSum))
            return true;
        return false;
    }
}

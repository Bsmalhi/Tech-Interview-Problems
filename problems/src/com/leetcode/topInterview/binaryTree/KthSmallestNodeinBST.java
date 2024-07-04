class KthSmallestNodeinBST{
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        //inorder traversal using iterative solution
        while(!stack.isEmpty() || curr != null){
            while(curr != null){ // iterate left
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0)
                return temp.val;
            if(temp.right != null)    
                stack.push(temp.right);
        }
        return -1;
    }
}

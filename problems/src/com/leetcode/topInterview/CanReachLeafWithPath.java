class CanReachLeafWithPath{
  public static canReachLeafWithoutZeroInPath(TreeNode root, List<Integer> path){
    if(root == null || root.val == 0)
      return false;
    path.add(root.val); // current val is valid so add to path result
    if(root.left == null && root.right == null) // path is valid lead node reached without 0 in path
      return true;
    if(canReachLeafWithoutZeroInPath(root.left, path))
      return true;
    if(canReachLeafWithoutZeroInPath(root.right, path)) // iterate to right side to reach leaf node
      return true;
    path.remove(path.size()-1); // last entry not valid as leaf not can't be reached so pop last element from path
    return false;
  }
  public static void main(String [] args){
    List<Integer> path = new ArrayList<>();
    System.out.println("Leaf not found: " + canReachLeafWithoutZeroInPath(root, path));
  }
}

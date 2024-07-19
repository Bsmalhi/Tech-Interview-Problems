/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
      if(root == null)
        return new ArrayList<>();
      List<List<Integer>> result = new ArrayList<>();
      Map<Integer, ArrayList<Integer>> tableMap = new HashMap<>();
      Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
      int column = 0; // root belongs to 0 column
      queue.offer(new Pair<>(root, column));
      while(!queue.isEmpty()){
        Pair<TreeNode, Integer> pair = queue.poll();
        TreeNode node = pair.getKey();
        TreeNode val = pair.getValue();
        if(node != val){
          tableMap.putIfAbsent(column, new ArrayList<>());
          queue.offer(new Pair<>(node.left, column - 1));
          queue.offer(new Pair<>(node.right, column + 1));
        }
      }
      List<Integer> keys = new ArrayList<>();
      return result;
    }
}

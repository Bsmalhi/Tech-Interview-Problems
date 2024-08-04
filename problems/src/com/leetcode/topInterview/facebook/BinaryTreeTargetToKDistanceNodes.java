
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
    Given the root of binary tree, value of target node target, int k 
    return an array of all values of all nodes that have a distance k from target node.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        buildGraphDfs(root, null, adjListMap);
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{target.val, 0}); // pair of node val and distance from target. We start from target node
        visited.add(target.val);
        // iterate over graph to find all the nodes from target with k distance apart
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int nodeVal = temp[0], distance = temp[1];
            if(distance == k){
                result.add(nodeVal);
                continue;
            }
            for(Integer neighbor : adjListMap.getOrDefault(nodeVal, new ArrayList<>())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
        }
        return result;
    }
    private void buildGraphDfs(TreeNode curr, TreeNode parent, Map<Integer, List<Integer>> adjListMap){
        if(curr != null && parent != null){
            int currVal = curr.val, parentVal = parent.val;
            adjListMap.putIfAbsent(currVal, new ArrayList<>());
            adjListMap.putIfAbsent(parentVal, new ArrayList<>());
            adjListMap.get(parentVal).add(currVal);
            adjListMap.get(currVal).add(parentVal);
        }
        if(curr != null && curr.left != null){
            buildGraphDfs(curr.left, curr, adjListMap);
        }
        if(curr != null && curr.right != null){
            buildGraphDfs(curr.right, curr, adjListMap);
        }
    }
}

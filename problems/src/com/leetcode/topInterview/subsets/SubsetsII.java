/*
You are given an array nums of integers, which that may contain duplicates. Return all possible subsets.
The solution must not contain duplicate subsets. You may return the solution in any order.
Input: nums = [1,2,1]
Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
*/
class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        helperDfs(nums, subsets, 0, new ArrayList<Integer>());
        return subsets;
    }
    private void helperDfs(int[] nums, List<List<Integer>> subsets, int i, List<Integer> list){
        if(i >= nums.length){
            subsets.add(new ArrayList<>(list));
        } else {
            list.add(nums[i]);
            helperDfs(nums, subsets, i + 1, list);
            list.remove(list.size() - 1);
            while(i + 1 < nums.length && nums[i] == nums[i+1])
                i++; // don't include duplicates nums so to avoid duplicate subsets
            helperDfs(nums, subsets, i + 1, list);
        }
    }
}

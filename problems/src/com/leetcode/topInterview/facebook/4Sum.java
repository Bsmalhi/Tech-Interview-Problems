class Solution {
  // using backtrack we can solve this or using one more loop with 3 sum problem
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSum = new ArrayList<>();
        Arrays.sort(nums);
        helperDfs(nums, 4, 0, target, fourSum, new ArrayList<Integer>());
        return fourSum;
    }
    private void helperDfs(int[] nums, int k, int start, int target, List<List<Integer>> foursum, List<Integer> quad){
        if(k != 2){
            for(int i = start; i < nums.length - (k - 1); i++){
                if(i > start && nums[i] == nums[i - 1])
                    continue;
                quad.add(nums[i]);
                helperDfs(nums, k - 1, i + 1, target - nums[i], foursum, quad);
                quad.remove(quad.size() - 1);
            }
            return;
        }
        int l = start, r = nums.length - 1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum > target){
                r--;
            } else if(sum < target){
                l++;
            } else{
                List<Integer> newQuad = new ArrayList<>(quad);
                newQuad.add(nums[l]);
                newQuad.add(nums[r]);
                foursum.add(newQuad);
                l++;
                while(l < r && nums[l] == nums[l - 1]) // skip duplicates
                    l++;
            }
        }
    }
}

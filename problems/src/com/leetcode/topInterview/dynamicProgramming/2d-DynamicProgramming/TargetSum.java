class TargetSum{
  public int findTargetSumWays(int [] nums, int target){
    Map<String, Integer> cache = new HashMap<>(); // nums[i] + amount, Count;
    return dfs(nums, 0, target, cache);
  }
  // so basically if you read the questions we have to use all the nums and 2 ways we can reach target '+' or '-'
    private int dfs(int[] nums, int i, int target, Map<String, Integer> memo){
        if(i == nums.length)
            return target == 0 ? 1 : 0;
        String key = i + "-" + target;
        if(memo.containsKey(key))
            return memo.get(key);

        int result = dfs(nums, i + 1, target - nums[i], memo) + dfs(nums, i + 1, target + nums[i], memo);
        memo.put(key, result);
        return memo.get(key);
    }
}

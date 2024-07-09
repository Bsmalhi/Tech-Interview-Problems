class PartitionEqualSubsetSum{
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for(int n: sums)
      sum += n;
    if(sum % 2 == 1) // cannot partition 
      return false;
    sum /= 2; // we need to just find if half of sum can be reached by a partition than its true to do equal partition
    Boolean [][] cache = new Boolean[nums.length][sum + 1];
    return dfs(nums, sum, cache, 0);
  }
  private boolean dfs(int[] nums, int sum, Boolean [] cache, int i){
    if(sum == 0) // found partition
      return true;
    if(sum < 0 || i == nums.length())
      return false;
    if(cache[i][sum] != null)
      return cache[i][sum];

    memo[i][sum] = dfs(nums, sum - nums[i], cache, i + 1) || dfs(nums, nums[i], cache, i + 1);
    return memo[i][sum];
  }
}

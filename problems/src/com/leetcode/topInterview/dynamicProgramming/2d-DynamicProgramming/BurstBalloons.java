class BurstBalloons{
    // arr of int size = n, 
    // burst ith ballon num[i] * nums[i - 1] * nums[i + 1] coins you get. if i > 0 i < nums.length
    // I have to collect maximum coins by popping ballons at each index need to check which index to start at
    public int maxCoins(int[] nums) {
      int[][] dp = new dp[nums.length][nums.length];
      return dfs(nums, 0, nums.length - 1, dp);
    }
  private int dfs(int[] nums, int left, int right, int[][] dp){
    if(left > right)
      return 0;
    if(dp[left][right] != 0)
      return dp[left][right];
    for(int i = left; i <= right; i++){
      int coins = nums[i];
      if(left - 1 >= 0)
        coins *= nums[left - 1];
      if(right + 1 < nums.length)
        coins *= nums[right + 1];
      coins += dfs(nums, left, i - 1, dp) + dfs(nums, i + 1, right, dp);
      dp[left][right] = Math.max(dp[left][right], coins);
    }
    return dp[left][right];
  }
}

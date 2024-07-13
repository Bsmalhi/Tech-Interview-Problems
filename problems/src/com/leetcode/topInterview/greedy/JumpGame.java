class JumpGame{
  // goal is to reach from 0 to last index and nums[i] is max jump that can be made at i
  public boolean canJump(int[] nums){
    int goal = nums.length - 1;
    for(int i = nums.length - 2; i >= 0; i--)
      if(i + nums[i] >= goal)
        goal = i
    return goal == 0;
  }
  public boolean canJumpDP(int[] nums){
    Boolean[] dp = new Boolean[nums.length];
    return dfs(nums, 0, dp);
  }
  private boolean dfs(int[] nums, int i, Boolean[] dp){
    if(i >= nums.length - 1)
      return true;
    if(dp[i] != null)
      return dp[i];
    int farthestJump = Math.min(i + nums[i], nums.length - 1);
    for(int next = i + 1; next <= farthestJump; next++){
      if(dfs(nums, next, dp)){
        dp[i] = true;
        return true;
      }
    }
    dp[i] = false;
    return dp[i];
  }
}

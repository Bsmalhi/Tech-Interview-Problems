class HouseRobber{
  /*
  You are given an integer array nums where nums[i] represents the amount of money the ith house has.
  The houses are arranged in a straight line, i.e. the ith house is the neighbor of the (i-1)th and (i+1)th house.
  You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system 
  will automatically alert the police if two adjacent houses were both broken into.
  */
  public int rob(int[] nums){
    int rob1 = 0, rob2 = 0;
    for(int n: nums){
      // rob either rob1 or n + rob2 because we cannot rob adjacent house then move rob1 and rob2 pointers
      // so basically dp[i] = max(nums[i] + nums[i - 2], nums[i - 1]);
      int temp = Math.max(rob1 + n, rob2);
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2
  }
      public int robWithDP(int[] nums) {
        if (nums.length <= 1)
            return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if(nums.length <= 2)
            return dp[1];

        // rob = [rob1, rob2, n, n+1]
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}

class RobHouses{
  public int rob(int [] nums){
    int rob1 = num[0];
    int rob2 = Math.max(nums[0], nums[1]);
    for(int i = 2; i < nums.length; i++){
      int temp = Math.max(nums[i] + rob1, rob2); // reccurrence relation dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1])
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2;
  }
}

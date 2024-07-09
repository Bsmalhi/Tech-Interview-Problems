class HouseRobberII{
  /*
  House topology is a circle so you cannot rob first and last houses together to find max. 
  Also no adjacent houses included in calculations
  */
  public int rob{int [] nums){
    if(nums.length <= 1)
        return nums[0];
    int excludeLast = robHelper(nums, 0, nums.length - 1);
    int includeLast = robHelper(nums, 1, nums.length);
    return Math.max(includeLast, excludeLast);
  }
  private int robHelper(int[] nums, int start, int end){
    int rob1 = 0, rob2 = 0;

    for(int i = start; i < end; i++){
      int temp = Math.max(rob1 + nums[i], rob2);
      rob1 = rob2;
      rob2 = temp;
    }
    return rob2;
  }
}

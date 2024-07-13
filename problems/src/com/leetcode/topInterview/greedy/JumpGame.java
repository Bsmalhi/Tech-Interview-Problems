class JumpGame{
  // goal is to reach from 0 to last index and nums[i] is max jump that can be made at i
  public int canJump(int[] nums){
    int goal = nums.length - 1;
    for(int i = nums.length - 2; i >= 0; i--)
      if(i + nums[i] >= goal)
        goal = i
    return goal == 0;
  }
}

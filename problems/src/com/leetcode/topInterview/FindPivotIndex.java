class FindPivotIndex{
  /*
  Input: nums = [1,7,3,6,5,6]
  Output: 3
  Explanation:
  The pivot index is 3.
  Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
  Right sum = nums[4] + nums[5] = 5 + 6 = 11
  */
  public int findPivot(int [] nums){
    int sum = 0, leftSum = 0;
    for(int n : nums)
      sum += n;
    for(int i = 0; i < nums.length; i++){
      if(leftSum == sum - leftSum - nums[i])
        return i;
      leftSum = nums[i];
    }
    return -1;
  }
}

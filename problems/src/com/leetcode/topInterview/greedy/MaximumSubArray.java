class MaximumSubArray{
  /*
  Given an array of integers nums, find the subarray with the largest sum and return the sum.
  A subarray is a contiguous non-empty sequence of elements within an array.
  Example 1:
  Input: nums = [2,-3,4,-2,2,1,-1,4]
  Output: 8
  */
  public int maxSum(int [] nums){
    if(nums.length < 1)
      return nums[0];
    int currSum = 0, max = nums[0];
    for(int n : nums){
      if(currSum < 0)
        currSum = 0;
      currSum += n;
      max = Math.max(max, currSum);
    }
    return max;
  }
}

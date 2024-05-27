class SlidingWindowShortestSubarray{
  public int shortestSubarray(int [] nums, int target){
    int l = 0, total = 0;
    int length = 0;
    for(int i = 0; i < nums.length; i++){
      total += nums[i];
      while(total >= target){
        length = Math.min(length, i - l + 1);
        l++;
        total -= nums[l];
      }
    }
    return length;
  }
}

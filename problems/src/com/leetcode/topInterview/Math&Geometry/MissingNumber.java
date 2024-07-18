class MissingNumber{
  // 0 <= n <= nums.length
  public int missing(int [] nums){
    int res = 0;
    for(int i = 0; i < nums.length + 1; i++) // so we add all in range 0 - n to res
        res += i;
    for(int i = 0; i < nums.length; i++)
        res -= nums[i]; // substract each num and then remaining is needed.
    return res;
  }
}

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
       int[] cache = new int[nums.length];
      Arrays.fill(cache, -1);
       int maxLength = 0;
       for(int i = 0; i < nums.length; i++)
         maxLength = Math.max(maxLength, dfs(nums, cache, i);
      return maxLength;
    }
  private int dfs(int []nums, int[] cache, int i){
    if(cache[i] != -1)
      return cache[i];
    int maxLength = 0;
    for(int j = i + 1; j < nums.length; j++){
      if(nums[i] < nums[j])
        maxLength = Math.max(maxLength, 1 + dfs(nums, cache, j));
    }
    cache[i] = maxLength;
    return cache[i];
  }
}

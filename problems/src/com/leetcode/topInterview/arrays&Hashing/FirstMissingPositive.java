class FirstMissingPositive {
    // return first positive min missing integer
    // O(n) and no extra space
    // nums[i] > 0 and <= n use 
    // cycle sort to put in order min positive in front of array use correctedIndex = nums[i] - 1 to swap nums[i] with
    // if not found then n + 1 is the actual missing number;
    public int firstMissingPositive(int[] nums) {
      int n = nums.length, i = 0;
      while(i < n){
        int correctedIndex = nums[i] - 1;
        if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctedIndex]){
          int temp = nums[i];
          nums[i] = nums[correctedIndex];
          nums[correctedIndex] = temp;
        } else {
          i++;
        }
      }
      for(i = 0; i < n; i++){
        if(nums[i] != i + 1)
          return i + 1;
      }
      return n + 1;
    }
}

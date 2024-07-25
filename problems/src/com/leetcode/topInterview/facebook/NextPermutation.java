class NextPermutation {
    /**
        next permutation is next lexicographically greater permutation of its integers
        if next permuation is possible start from back and check if decreasing order 
        we need to reverse to provide 
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]) // until numbers are in decreasing order keep looping
          i--;
        if(i >= 0){ // i is not out of bounds we found i num to swap
          int j = nums.length - 1;
          while(j >= 0 && nums[j] <= nums[i])
            j--;
          swap(nums, i, j);
        }
      reverse(nums, i + 1); // reverse as we want to give just greater num
    }
  private void reverse(int [] nums, int start){
    int i = start, j = nums.length - 1;
    while(i < j){
      swap(nums, i, j);
      i++;
      j--
    }
  }
  private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

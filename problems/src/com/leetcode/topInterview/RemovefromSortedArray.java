class RemovefromSortedArray{
  public int removeDuplicates(int[] nums) {
    if( nums.length <= 1){
            return nums.length;
    }
    int i = 1, j = 1;
    while(j < nums.length){
      if(nums[j] != num[j - 1]){
        nums[i] = nums[j];
        i++;
      }
      j++;
    }
    return i+1;
  }
}

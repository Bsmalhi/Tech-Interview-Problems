class ThreeSum{
  public List<List<Integer>> threeSum(int[]nums, int target){
    List<List<Integer>> result = new ArrayList<>();
    for(int i = 0; i < nums.length; i++){
      if(i > 0 && nums[i] == nums[i-1]) // skip duplicates
        continue;
      int j = i + 1;
      int k = nums.length - 1;
      while(j < k){
        int sum = nums[j] + nums[i] + nums[k];
        if(sum < 0){
          j++;
        } else if( sum > 0){
          k--;
        } else {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          //skip duplicates
          if(j < k && nums[j] == nums[j+1]) j++;
          if(j < k && nums[k] == nums[k - 1]) k--;
          j++;
          k--;
        }
      }
    }
    return result;
  }
}

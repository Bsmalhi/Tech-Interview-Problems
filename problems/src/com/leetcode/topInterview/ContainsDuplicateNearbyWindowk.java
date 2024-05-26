class ContainsDuplicateNearbyWindowk{
  // Sliding Window problem using HashSet
  public int containsDuplicateInWindow(int [] nums, int k){
    if(nums.length <= 1)
      return false;
    Set<Integer> set = new HashSet<>();
    for(int r = 0; r < nums.length(); r++){
      if(set.contains(nums[r])
         return true;
      set.add(nums[r]);
      if(set.size() > k)
        set.remove(nums[r - k]);
    }
    return false;
  }
}

class LongestConsecutiveSequence{
  public int longestSequence(int [] nums){
    int count = 0;
    Set<Integer> sequenceSet = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
      // this helps find starting point
      if(!set.contains(nums[i] - 1)){
        int length = 0;
        // this helps find next sequence from nums[i]
        while(set.contains(nums[i] + length){
          length++;
          count = Math.max(count, length);
        }
      }
    }
    return count;
  }
}

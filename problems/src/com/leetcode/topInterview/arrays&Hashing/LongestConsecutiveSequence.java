class LongestConsecutiveSequence{
  /*
  Input: nums = [2,20,4,10,3,4,5]
  Output: 4
  */
  public int longestConsecutiveSequence(int nums){
    int longest = 0;
    Set<Integer> set = new HashSet<>();
    for(int n: nums)
      set.add(n);

    for(int i = 0; i < nums.length; i++){
      // this is to check we begin sequence checking from start of sequence
      if(!set.contains(nums[i] - 1){
        int length = 0;
        while(set.contains(nums[i] + length){
          length++;
          longest = Math.max(longest, length);
        }
      }
    }
    return longest;
  }
}

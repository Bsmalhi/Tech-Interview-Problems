class Solution {
    /**
    Given inclusive range [lower,upper] and sorted unique int arr nums where all elements are within inclusive range
    No. x is considered missing if x is in range [lower, upper] and x is not in nums
    Return the shortest sorted list of ranges that exactly covers all the missing numbers.
    Input: nums = [0,1,3,50,75], lower = 0, upper = 99
    Output: [[2,2],[4,49],[51,74],[76,99]]
     */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();
        int n = nums.length;
      if(n == 0){
        missingRanges.add(Arrays.asList(lower, upper));
        return missingRanges;
      }
      if(lower < nums[0]){ // meaning first number is not in the range or equal to lower than add missing ranges in list
        missingRanges.add(Arrays.asList(lower, nums[0] - 1);
      }
      for(int i = 0; i < n - 1; i++){
        if(nums[i + 1] - nums[i] <= 1) // if difference is less than or equal to 1 then no missing range present so continue
          continue;
        missingRanges.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
      }
      if(upper > nums[n - 1]){ // last element is not equal to upper range
        missingRanges.add(Arrays.asList(nums[n - 1] + 1, upper);
      }
      return missingRanges;
    }
}

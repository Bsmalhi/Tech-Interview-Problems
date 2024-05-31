class Solution {
    /*
    You are given an array of integers nums containing n + 1 integers. 
    Each integer in nums is in the range [1, n] inclusive.
    Every integer appears exactly once, except for one integer which appears 
    two or more times. Return the integer that appears more than once.
    Input: nums = [1,2,3,2,2]
    Output: 2
    */
    public int findDuplicate(int[] nums) {
       int slow = 0, fast = 0;
      while(true){ // bcoz arr is guarnteed to contain duplicate so slow is going to meet fast;
        slow = nums[slow];
        fast = nums[nums[fast]];
        if(slow == fast)
          break;
      }
      int slow2 = 0;
      while(slow != slow2){
        slow = nums[slow];
        slow2 = nums[slow2];
      }
      return slow;
    }
}

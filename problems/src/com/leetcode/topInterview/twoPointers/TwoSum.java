class Solution {
    //Array is sorted provided in problem
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
      while(l < r){
        if(nums[l] + nums[r] < target){
          l ++;
        } else if(nums[l] + nums[r] > target){
          r --;
        } else {
          break;
        }
      }
      return new int[]{l + 1, r + 1};
    }
}

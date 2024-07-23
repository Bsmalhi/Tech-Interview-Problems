class Solution {
    // return peak index in a num array
    // using binary search
    public int findPeakElement(int[] nums) {
       int l = 0, r = nums.length - 1;
      while(l < r){
        int mid = l + (r - l)/2;
        if(nums[mid] > nums[mid + 1]){ // meaning mid is on the left
          r = mid;
        } else { // meaning the mid is on the right
          l = mid + 1;
        }
      }
      return l;
    }
}

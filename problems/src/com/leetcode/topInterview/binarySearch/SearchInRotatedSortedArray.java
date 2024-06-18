class SearchInRotatedSortedArray{
  /*
  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
  */
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while(l <= r){
      int mid = l + (r - l)/ 2;
      if(nums[mid] == target)
        return mid;
      // left sorted arr meaning nums[l] = 0 < nums[mid] = 3
      if(nums[l] < nums[r]){
        if(nums[mid] < target || target < nums[l]){ //second case where target = 3 and nums[l] might be 5
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else { // right rotated sorted arr
        if(nums[mid] > target || target < nums[r]){
          r = mid - 1;
        } else {
          mid + 1;
        }
      }
    }
    return -1;
  }
}

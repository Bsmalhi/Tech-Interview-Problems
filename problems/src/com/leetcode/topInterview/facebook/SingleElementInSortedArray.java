class SingleElementInSortedArray {
    /**
    Given sorted array of int every element appears exactly twice, except for one element.
    return the single element that appears only once.
    Your solution must run in O(log n) time and O(1) space.
    4 cases:
    Case 1: if halves are even and mid's pair is to right then single element is in right side.
    Case 2: if halves are odd and mid's pair is to the right then single element is in left side.
    Case 3: if halves are even and mid's pair is to the left then single element is in left side.
    Case 4: if halves are odd and mid's pair is to the left then single element is in right side.
    1,1,2,3,3,4,4,5,5,6,6
     */
    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        // we are using while (i < j) ensures that when they converge (i.e., i == j), the only remaining element is the non-duplicate element
        while(i < j){
          int mid = i + (j - i) / 2;
          boolean halvesAreEven = (j - mid) % 2 == 0;
          if(nums[mid] == nums[mid + 1]){
            if(halvesAreEven){
              i = mid + 2;
            } else {
              j = mid - 1;
            }
          } else if(nums[mid] == nums[mid - 1]){
            if(halvesAreEven){
              j = mid - 2;
            } else {
              i = mid + 1;
            }
          } else {
            return nums[mid];
          }
        }
      return nums[i]; // only last remaining element is the single element
    }
}

class MergeSortedArray{
  // arr is sorted in asc 
  // start from end with 3 pointers 
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;
        for(int p = m + n - 1; p >= 0; p--){
          if(p2 < 0)
            break;
          if(p1 >= 0 && nums1[p1] > nums[p2])
            nums1[p] = nums[p1--];
          else
            nums1[p] = nums[p2--];
        }
    }
}

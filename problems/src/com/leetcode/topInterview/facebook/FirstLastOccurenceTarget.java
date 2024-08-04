class FirstLastOccurenceTarget {
    /**
    Given an array of int nums sorted in ascending order
    find the starting and ending position of a given target value
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
     */

    public int[] searchRange(int[] nums, int target) {

        int firstOccurence = findOccurence(nums, target, true);

        if(firstOccurence == -1)
            return new int[]{-1, -1};

        int lastOccurence = findOccurence(nums, target, false);

        return new int[]{firstOccurence, lastOccurence};
    }

    private int findOccurence(int[] nums, int target, boolean isFirst){
        int N = nums.length;
        int begin = 0, end = N - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            if(nums[mid] == target){
                if(isFirst){
                    // this means we found our lower bound
                    if(mid == begin || nums[mid - 1] != target)
                        return mid;
                    // search on the lower side for firstOccurence of target
                    end = mid - 1;
                } else {
                    // meaning no need to search for last occurence on right side as we found the bound
                    if(mid == end || nums[mid + 1] != target)
                        return mid;
                    // we have to find the last occurence so search in right bound
                    begin = mid + 1;
                }
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRangeLinearSearch(int[] nums, int target) {
        if(nums.length < 1)
            return new int[]{-1, -1};
        
        int i = 0, j = nums.length - 1;
        while(i <= j){
            if(nums[i] != target){
                i++;
            }
            if(nums[j] != target)
                j--;
            if(i <= j && nums[i] == target && nums[j] == target)
                return new int[]{i, j};
        }

        return new int[]{-1, -1};
    }
}

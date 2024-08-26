class KthPositiveMisingInteger {
  /**
    Sorted array we can use binary search to get pivot then check
    if curr num - index - 1 falls < k means The number of positive integers which are 
    missing before the arr[idx] is equal to arr[idx] - idx - 1 => 3 - 2 = 0
    then kth missing is in right side
    otherwise kth missing on right side
  */
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(arr[pivot] - pivot - 1 < k){
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left + k;
    }
}

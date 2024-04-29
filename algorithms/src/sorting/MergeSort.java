package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {1,6,2,5,4,3};
        for( int i: sortArray(arr))
            system.out.println( i +" ");
    }

    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int[] mergeSort(int [] nums, int s, int e){
        if((e-s+1) <= 1) // edge case end == start
            return nums;
        int mid = s +(e-s)/2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid+1, e);
        merge(nums, s, mid, e);
        return nums;
    }
    private void merge(int[] nums, int s, int mid, int e){
        int[] leftArr = new int[(mid - s) + 1];
        int[] rightArr = new int[e - mid];
        for(int i = 0; i < leftArr.length; i++)
            leftArr[i] = nums[s + i];
        for(int i = 0; i < rightArr.length; i++)
            rightArr[i] = nums[mid+1+i];

        int i = 0, j = 0, k = s;
        while(i < leftArr.length && j < rightArr.length){
            if(leftArr[i] <= rightArr[j]){
                nums[k] = leftArr[i];
                i++;
            } else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i < leftArr.length){
            nums[k] = leftArr[i];
            k++; i++;
        }
        while(j < rightArr.length){
            nums[k] = rightArr[j];
            k++; j++;
        }
    }
}

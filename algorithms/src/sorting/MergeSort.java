package sorting;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {1,6,2,5,4,3};
        mergeSort(arr);
    }

    private static void mergeSort(int[] arr) {
        if(arr.length <1)
            return;
        mergeSort(arr, 0, arr.length -1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start < end){

        }
    }
}

public class QuickSort{
  public static void main(int[] String[] args) {
        int [] arr = {1,6,2,5,4,3};
        for( int i: sortArray(arr))
            system.out.println( i +" ");
  }
  private int[] sortArray(int[] arr){
    quickSort(int[] arr, int start, int end);
    return arr;
  }
  private void quickSort(int[] arr, int start, int end){
    if((end - start + 1) <= 1)
      return;
    int pivot = arr[end];
    int left = start;

    for(int i = start; i < end; i++){
      if(arr[i] < pivot){
        int temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
        left++;
      }
    }
    // swap pivot to left and left to end value
    arr[end] = arr[left];
    arr[left] = pivot;

    quickSort(arr, start, left - 1);
    quickSort(arr, left + 1, end);
  }
}

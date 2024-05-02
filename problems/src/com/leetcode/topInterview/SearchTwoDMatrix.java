class SearchTwoDMatrix{
  public static void main(String[] args){
    int[][] arr = {};
  }
  private static boolean search(int[] arr, int target){
      int row = arr.length, col = arr[row].length;
      int top = 0, bottom = row - 1;
      while(top <= bottom){
        int mid = top + (bottom - top)/2;
        if(target > arr[mid][col-1]){
          top = mid + 1;
        } else if(target < arr[mid][0]){
          bottom = mid - 1;
        } else {
          break; // found target row which is mid
        }
      }
      if(top > bottom){
        return false; // not found target
      }
      row = top + (bottom - top)/2; // update the row to match mid
      int left = 0, right = col -1;
      while(left <= right){
        int mid = left + (right - left)/2;
        if(target == arr[row][mid]){
          return true;
        } else if(target > arr[row][mid]){
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
  }
}

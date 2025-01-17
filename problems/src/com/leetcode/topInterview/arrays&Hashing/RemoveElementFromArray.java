/*
  Remove val from the array and change array so that k elements != val are moved in front of the array.
  https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
*/
class RemoveElementFromArray{
  public int removeElement(int [] arr, int val){
    int i = 0, j = arr.length - 1;
    if(arr.length == 0){
      return 0;
    }
    if(arr.length == 1){
      return arr[0] == val ? 0 : 1;
    }
    while(i <= j){
      if(arr[i] == val){
        arr[i] = arr[j];
        j--;
      } else {
        i++;
      }
    }
    return i;
  }
}

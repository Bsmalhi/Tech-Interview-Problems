/*
  Problem is to find if num * 2 exists such that i != j
  https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
*/
class CheckIfNandItsDoubleExist {
  public boolean checkDoubleExists(int [] arr){
    Set<Integer> hashset = new HashSet<>();
    for(int num : arr){
      // num % 2 makes sure we found exact match bcoz num / 2 converts float into floor num
      if(hashset.contains(num * 2) || (hashset.contains(num /2) && num % 2 == 0)){
        return true;
      }
    }
    return false;
  }
}

class ProductExceptSelf{
  //basically we are calculating prefix with first pass and storing value in result array instead of creating extra space
  // then on second pass calculate the postfix from the numbers int res = new int[nums.length];
  public int[] product{
    int res[] = new int[nums.length];
    int left = 1, right = 1;
    for(int i = 0; i < nums.length; i ++){
      res[i] = left;
      left *= nums[i];
    }
    for(int i = nums.length - 1; i >= 0; i--){
      res[i] *= right;
      right *= nums[i];
    }
    return res;
  }
}

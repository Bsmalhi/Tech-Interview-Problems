class PlusOne{
  public int[] plusOne(int[] digits){
    int [] result = new int[digits.length];
    int carry = 1;
    for(int i = digits.length - 1; i >= 0; i--){
      int sum = digits[i] + carry;
      if(sum / 10 != 0){
        digits[i] = sum % 10;
        result[i + 1] = digits[i];
        carry = 1;
      } else {
        digits[i] = sum;
        result[i + 1] = sum;
        carry = 0;
      }
    }
    if(carry == 1){
      result[0] = 1;
      return result;
    }
    return digits;
  }
}

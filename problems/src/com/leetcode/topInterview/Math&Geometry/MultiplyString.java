class MultiplyString{
  public String multiply(String num1, String num2){
    StringBuilder sb = new StringBuilder();
    int [] nums = new int[num1.length() + num2.length()];
    for(int i = num1.length() - 1; i >= 0; i--){
      for(int j = num2.length() - 1; j >= 0; j--){
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int p1 = i + j; // index to store carry
        int p2 = i + j + 1; // index to store multiplication
        int sum = mul + nums[p2];
        nums[p1] += sum / 10; // store carry
        nums[p2] = sum % 10; // store sum
      }
    }
    for(int n: nums){
      if(sb.length() == 0 && n == 0)
        continue;
      res.append(n);
    }
    return res.length() == 0 ? "0" : res.toString();
  }
}

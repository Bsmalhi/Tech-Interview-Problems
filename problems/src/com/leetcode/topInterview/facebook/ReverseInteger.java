class ReverseInteger{
  public int reverseInt(int x){
    boolean negative = x < 0 ? true : false;
    x = Math.abs(x);
    int result = 0;
    while(x != 0){
      if(x > Integer.MAX_VALUE/10)
        return 0;
      result *= 10;
      result += x % 10;
      x = x / 10;
    }
    return negative ? - result : result;
  }
}

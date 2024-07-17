class Powxn{
  public double pow(double x, int n){
      double res = 0;
    res = helper(x, n);
    return n < 0 ? 1/res : res;
  }
  private double helper(double x, int n){
    if(x == 0)
      return 0;
    if(n == 0) // is raise to pow is 0 return val should be 1
      return 1;
    double half = helper(x, n/2); // doing this reduces the time complexity into half
    if(n % 2 == 0){
      return half * half;
    }
    return half * half * n; // if n is odd
  }
}

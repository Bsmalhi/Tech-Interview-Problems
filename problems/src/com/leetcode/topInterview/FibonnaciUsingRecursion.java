class FibonnaciUsingRecursion{
  public int getFibonnaci(int n){
    if(n <= 1)
      return n;
    return getFibonnaci(n - 1) + getFibonnaci(n - 2);
  }
  public int getFibonnaciMemoization(int n){
    if(n <= 1) 
      return n;
    int [] memoization = new int[n];
    return helperTopDown(n, memo);
  }
  private int helperTopDown(int n, int [] memo){
    if(n <= 1)
      return n;
    if(memo[n] != 0)
      return memo[n];
    memo[n] = helperTopDown(n - 1, memo) + helperTopDown(n - 2, memo);
    return memo[n];
  }
}

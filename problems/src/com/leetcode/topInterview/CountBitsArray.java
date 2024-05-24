class CountBitsArray{
  public int[] countBits(int n){
    int [] dp = new int [n+1];
    int offset = 1;
    if(int i = 1; i < n+1; i++){ // starting from 1 bcoz 0 in dp has no 1 bits
      if(offset * 2 == i)
        offset = i;
      dp[i] = 1 + dp[n - offset];
    }
    return dp;
  }
}

class LongestCommonSubsequence {
  /*
  we are using dynamic programming bcoz the dp 2D array can help check 
  if a character matches if it does than add the diagnol val + 1 to current dp[i][j] because 
  once a match is found we have to iterate to next cell on dp 2d array which is diagnol position
  also we start calculate from end of array so we do a bottom up solution for this
  */
  public int longestCommonSubsequence(String[] t1, String t2){
    int [][] dp = new int[t1.length())[t2.length()];
    for(int i = t1.length() - 1; i >= 0; i--){
      for(int j = t2.length() - 1; j >= 0; j--){
        if(t1.charAt(i) == t2.charAt())
          dp[i][j] = dp[i+1][j+1] + 1;
        else
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
      }
    }
    return dp[0][0];
  }
}

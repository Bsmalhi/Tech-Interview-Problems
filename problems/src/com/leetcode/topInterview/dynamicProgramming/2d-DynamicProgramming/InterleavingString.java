class InterleavingString{
    // 3 strings return true if s3 formed by interleaving s1 and s2 (all lowercase)
    // difference between s1 - s2 <= 1
    // s = s1 + s2 + .... + sn
    // t = t1 + t2 + ... + tm
    public boolean isInterleave(String s1, String s2, String s3) {
      if(s2.length() + s1.length() != s3.length())
        return false;
      Boolean[][] dp = new Boolean[s1.length()][s2.length()];
      return dfs(0, 0, s1, s2, s3, dp);
    }
    private boolean dfs(int i, int j, String s1, String s2, String s3, Boolean[][] dp){
      if(i == s1.length() && j == s2.length())
        return true;
      if(dp[i][j] != null)
        return dp[i][j];
      if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)){
        if(dfs(i + 1, j, s1, s2, s3, dp)){
         dp[i][j] = true;
          return dp[i][j];
        }
      }
      if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j)){
        if(dfs(i, j + 1, s1, s2, s3, dp)){
          dp[i][j] = true;
          return dp[i][j];
        }
      }
      dp[i][j] = false;
      return false;
    }
}

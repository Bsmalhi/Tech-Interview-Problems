class DistinctSubsequence{
      // Return the number of distinct subsequences of s which are equal to t.
      public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] arr: dp)
          Arrays.fill(arr, -1);
        return dfs( 0, 0, s, t, dp);
      }
    private int dfs(int i, int j, String s, String t, int[][] dp){
      if(j == t.length()) // even empty string t is a subsequence
        return 1;
      if(i == s.length()) // no subsequence possible now
        return 0;
      if(dp[i][j] != -1)
        return dp[i][j];
      int count = 0;
      if( s.charAt(i) == t.charAt(j))
        count += dfs(i + 1, j + 1, s, t, dp); 
      count += dfs(i + 1, j, s, t, dp); // not including char from s
      dp[i][j] = count;
      return dp[i][j];
    }
}

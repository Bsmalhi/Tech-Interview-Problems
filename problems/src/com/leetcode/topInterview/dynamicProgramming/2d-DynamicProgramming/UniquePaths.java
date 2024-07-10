class UniquePaths{
  public int UniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for(int[] arr: dp)
      Arrays.fill( arr, 1)

    for(int i = 1; i < m; i++){
      for(int j = 1; j < n; j++){
        dp[i][j] = dp[i - 1][j] + dp[i][j-1]; // no. of paths is sum of both adjacent cells in last row and col
      }
    }
    return dp[m - 1][n - 1];
  }
}

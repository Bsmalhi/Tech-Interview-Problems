class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int row = obstacleGrid.length, col = obstacleGrid[0].length;
      return uniquePathsWithObstacles(obstacleGrid, new int[row][col], 0, 0, row, col);
    }
    public int uniquePathsWithObstacles(obstacleGrid, int[][] cache, int r, int c, int row, int col){
      if(r < 0 || c < 0 || r >= row || c >= col || obstacleGrid[r][c] == 1)
        return 0;
      if(r == row - 1 && c == col - 1){
        cache[r][c] = 1;
        return cache[r][c];
      }
      if(cache[r][c] != 0)
        return cache[r][c];
      cache[r][c] = uniquePathsWithObstacles(obstacleGrid, cache, r+1, c, row, col) +
                    uniquePathsWithObstacles(obstacleGrid, cache, r, c+1, row, col);
      return cache[r][c];
    }
    public int uniquePathsWithObstaclesWithDp(int[][] obstacleGrid) {
      int row = obstacleGrid.length, col = obstacleGrid[0].length;
      int [] dp = new int[col];
      dp[0] = 1;
      for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++){
          if(obstacleGrid[i][j] == 1){
            dp[j] = 0;
          } else if( j > 0){
            dp[j] = dp[j] + dp[j - 1];
          }
        }
      }
        return dp[0];
  }
}

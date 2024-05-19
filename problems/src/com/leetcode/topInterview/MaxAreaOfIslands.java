class MaxAreaOfIslands{
      public int maxAreaOfIsland(int[][] grid) {
        int maxIslands = 0;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
              maxIslands = Math.max(maxIslands, findIslandWithMaxArea(grid, i, j));
            }
          }
        }
        return maxIslands;
      }
  private int findIslandWithMaxArea(int[][] grid, int r, int c){
    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
      return 0;
    
    int count = 0;
    if(grid[r][c] == 1)
      count++;
    
    grid[r][c] = 0; // mark island cell visited
    
    count += findIslandWithMaxArea(grid, r+1, c);
    count += findIslandWithMaxArea(grid, r-1, c);
    count += findIslandWithMaxArea(grid, r, c+1);
    count += findIslandWithMaxArea(grid, r, c-1);
    
    return count;
  }
}
/*
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],
                [0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
                [0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
                [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
*/

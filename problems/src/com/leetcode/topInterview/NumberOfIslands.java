class NumberOfIslands {
     public int numIslands(char[][] grid) {
       int countIslands = 0;
       for(int i = 0; i < grid.length; i++){
         for(int j = 0; j < grid[0].length; j++){
           if(grid[i][j] == '1'){
             markIslandVisited(grid, i, j);
             countIslands++;
           }
         }
       }
       return countIslands;
    }
  private void markIslandVisited(char[][] grid, int r, int c){
    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0')
        return;
    grid[r][c] = '0';
    markIslandVisited(grid, r+1, c);
    markIslandVisited(grid, r-1, c);
    markIslandVisited(grid, r, c+1);
    markIslandVisited(grid, r, c-1);
  }
  
}

/*
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

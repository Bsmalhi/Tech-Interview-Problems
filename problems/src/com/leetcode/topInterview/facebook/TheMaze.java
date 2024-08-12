class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
      int row = maze.length, c = maze[0].length;
      boolean[][] visited = new boolean[row][col];
      return dfs(row, col, maze, start, destination, visited);
    }
    private boolean dfs(int row, int col, int[][] maze, int [] curr, int [] destination, boolean[][] visited){
      if(visited[curr[0]][curr[1]])
        return false;
      if(curr[0] == destination[0] && curr[1] == destination[1])
        return true;
      visited[curr[0]][curr[1]] = true;
      int [] directions = {{1,0},{-1,0}, {0,1}, {0,-1}};
      // iterate over all directions to check if its not visited and if we reach destination while visiting neighbors than return true
      for(int [] dir: directions){
        int r = curr[0], c = curr[1];
        // Move the ball in the chosen direction until it can.
        while(r >= 0 && c >= 0 && r < row && c < col && maze[r][c] == 0){
            r += dir[0];
            c += dir[1];
        }
        // bcoz ball hit the wall move the ball back by reverting last move r - dir[0], c - dir[1] then do dfs
        if(dfs(row, col, maze, new int[]{r - dir[0], c - dir[1]}, destination, visited))
          return true;
      }
      return false;
    }
}

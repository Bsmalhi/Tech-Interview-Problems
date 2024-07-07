class RottenOranges{
  public int timeToRotten(int [][] grid){
    int row = grid.length, col = grid[0].length;
    int fresh = 0;
    Queue<int[]> rottenOranges = new LinkedList<>();
    for(int i = 0; i < row; i ++){
      for(int j = 0; j < col; j++){
        if(grid[i][j] == 1)
          fresh++;
        if(grid[i][j] == 2)
          rottenOranges.offer(new int[]{i, j});
      }
    }
    int mins = 0
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    while(fresh > 0 && !rottenQueue.isEmpty()){
        int size = rottenQueue.size();
        for(int i = 0; i < size; i++){
            int[] temp = rottenQueue.poll();
            int r = temp[0], c = temp[1];
            if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == 0)
                continue;
            int neighbors[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for(int[] dir: neighbors){
                int dr = r + dir[0], dc = c + dir[1];
                if(dr < 0 || dc < 0 || dr >= row || dc >= col || 
                    visited.contains(dr+","+dc) || grid[dr][dc] != 1)
                    continue;
                grid[dr][dc] = 2;
                rottenQueue.offer(new int[]{dr,dc});
                visited.add(dr+","+dc);
                fresh--;
            }
        }
        mins++;
    }
    return fresh == 0 ? mins : -1;
  }
}

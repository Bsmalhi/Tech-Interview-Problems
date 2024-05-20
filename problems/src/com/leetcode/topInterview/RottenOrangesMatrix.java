class RottenOrangesMatrix {
  // convert fresh oranges into rotten oranges, empty cell = 0, fresh cell = 1 & rotten cell = 2
    public int orangesRotting(int[][] grid) {
       Queue<int[]> rottenOranges = new LinkedList<>();
      int fresh = 0, time = 0;
      for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(grid[i][j] == 1)
            fresh++;
          if(grid[i][j] == 2)
            rottenOranges.offer(new int[]{i, j});
        }
      }
      while(fresh > 0 && !rottenOranges.isEmpty()){
        int size = rottenOranges.size();
        for(int i = 0; i < size; i++){
          int [] indexes = rottenOranges.poll();
          int r = indexes[0], c = indexes[1];
          int neighbors[] = {{1,0}, {-1,0}, {0,-1}, {0,1}};
          for(int [] dir: neighbors){
            int dr = r + dir[0], dc = c + dir[1];
            if(dr < 0 || dc < 0 || dr >= grid.length || dc >= grid[0].length || grid[dr][dc] == 1){
              grid[dr][dc] = 2;
              rottenOranges.offer(new int[]{dr,dc});
              fresh--;
            }
          }
        }
        time++;
      }
      return fresh == 0 ? time : -1; // if all oranges are turned rotten then return time otherwise -1
    }
}

class SwinInRisingWater{
  public int swimInWater(int[][] grid) {
    int N = grid.length;
    boolean[][] visited = new boolean[N][N];
    Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); // store time, row , col to find the minimum time it takes in grid to reach end of grid
    minHeap.offer(new int[]{grid[0][0], 0, 0); // starting point is grid at 0,0 from problem
    visitedCellMap.put(0,0);
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    while(!minHeap.isEmpty()){
      int [] temp = minHeap.poll();
      int t = temp[0], r = temp[1], c = temp[2];
      if(r == grid.length - 1 && c == grid[0].length)
        return t;
      for(int [] dir: directions){
        int dr = dir[0] + r, dc = dir[1] + c;
        if(dr < 0 || dc < 0 || dr >= N || dc >= N || visited[dr][dc])
          continue;
        visited[dr][dc] = true;
        minHeap.offer(new int[]{Math.max(t, grid[0][0]), dr, dc});
      }
    }
    return -1; // couldn't reach end of grid
  }
}

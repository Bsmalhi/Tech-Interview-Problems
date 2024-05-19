class MatricBreadthFirstSearch{
  //Breadth first search Graph matrix traversal to find out the shorted path to bottom right cell
  public int shortestPath(int[][] grid) {
    int row = grid.length, col = grid[0].length;
    Set<String> visitedIndexes = new HashSet<>();
    Queue<int[]> queueIndexes = new LinkedList<>();
    queueIndexes.offer(new int[] {0,0});
    visitedIndexex.add("0,0");
    int length = 0;
    while(!queueIndexes.isEmpty()){
      int size = queueIndexes.size();
      for(int i = 0; i < size; i++){
        int [] indexes = queueIndexes.poll();
        int r = indexes[0], c = indexes[1];
        if(r == row-1 && c == col -1)
          return length;
        int neighbors[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int [] dir: neighbors){
          int dr = r + dir[0], dc = c + dir[1];
          if(dr < 0 || dc < 0 || dr >= grid.length || dc >= grid[0].length || visited.contains(dr+","+dc) || grid[dr][dc] == 1)
            continue;
          queueIndexes.offer(new int[] {dr, dc});
          visitedIndexes.add(dr+","+dc);
        }
      }
      length++;
    }
    return -1;
  }
}

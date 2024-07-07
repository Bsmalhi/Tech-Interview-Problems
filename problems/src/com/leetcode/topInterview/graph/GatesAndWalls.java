class GatesAndWalls {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); // to track gates
        // start from gates 0 then +1 from there to calculate distance from cells to gate
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0)
                    queue.offer(new int[]{i, j});
            }
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        while(!queue.isEmpty()){
            int [] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            for(int [] dir: dirs){
                int dr = dir[0] + r, dc = dir[1] + c;
                if(dr < 0 || dr >= grid.length || dc < 0 || dc >= grid[0].length || grid[dr][dc] != Integer.MAX_VALUE)
                    continue;
                grid[dr][dc] = grid[r][c] + 1;  
                queue.offer(new int[]{dr, dc});
            }
        }
    }
}

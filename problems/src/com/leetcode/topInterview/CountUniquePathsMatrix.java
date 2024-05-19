class CountUniquePathsMatrix {
    public int countPaths(int[][] grid) {
        Set<String> visited = new HashSet<String>();
        return helperDfs(grid, 0, 0, visited);
    }
    private int helperDfs(int[][] grid, int row, int col, Set<String> visited){
        String s = row + "-" + col;
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || 
            visited.contains(s) || grid[row][col] == 1)
            return 0; // not possible to reach bottom right cell
        if(row == grid.length-1 && col == grid[0].length-1)
            return 1; // success
        visited.add(s);
        int count = 0;
        count += helperDfs(grid, row+1, col, visited); // go down
        count += helperDfs(grid, row-1, col, visited); // go up
        count += helperDfs(grid, row, col+1, visited); // go right
        count += helperDfs(grid, row, col-1, visited); // go left

        visited.remove(s);
        return count;
    }
}

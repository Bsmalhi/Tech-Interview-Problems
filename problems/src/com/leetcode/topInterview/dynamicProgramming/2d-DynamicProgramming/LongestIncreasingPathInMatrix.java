class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] visited = new int[row][col];
        for( int[] arr: visited )
            Arrays.fill(arr, -1);
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j] == -1)
                    dfs(i, j, matrix, visited, -1);
            }
        }
        int result = Integer.MIN_VALUE;
        for(int [] arr: visited){
            for(int n : arr)
                result = Math.max(result, n);
        }
        return result;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] visited, int prev){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        if(visited[i][j] != -1)
            return visited[i][j];
        
        int down = dfs(i + 1, j, matrix, visited, matrix[i][j]);
        int right = dfs(i, j + 1, matrix, visited, matrix[i][j]);
        int up = dfs(i - 1, j, matrix, visited, matrix[i][j]);
        int left = dfs(i, j - 1, matrix, visited, matrix[i][j]);

        visited[i][j] = 1 + Math.max(Math.max(left, right), Math.max(up, down));

        return visited[i][j];
    }
}

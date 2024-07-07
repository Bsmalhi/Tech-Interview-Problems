class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] atlantic = new boolean[row][col]; //array for cheching if rain water can flow out to atlantic ocean
        boolean[][] pacific = new boolean[row][col]; //array for cheching if rain water can flow out to pacific ocean

        for(int i = 0; i < col; i++){
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific); // top row pacific ocean start
            dfs(heights, row - 1, i, Integer.MIN_VALUE, atlantic); // bottom row atlantic ocean starts
        }
        for(int i = 0; i < row; i++){
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific); // left side pacific ocean start
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlantic); // right side row atlantic ocean starts
        }
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < col; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    List<Integer> temp = new ArrayList();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean){
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < prev || ocean[i][j])
            return;
        ocean[i][j] = true;
        dfs(heights, i + 1, j, heights[i][j], ocean);
        dfs(heights, i - 1, j, heights[i][j], ocean);
        dfs(heights, i, j + 1, heights[i][j], ocean);
        dfs(heights, i, j - 1, heights[i][j], ocean);
    }
}

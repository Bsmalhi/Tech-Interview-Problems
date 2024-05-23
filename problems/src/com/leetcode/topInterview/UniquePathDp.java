class UniquePathDp{
  public int uniquePathUsingDp(int row, int col){
     int [] prevRow = new int[col];
     for(int i = 0; i < row; i++){
       int [] currRow = new int[col];
       currRow[col - 1] = 1; // last col cell of each row will be initialized to 1
       for(int j = col - 2; j >= 0; j--){
         currRow[j] = currRow[j + 1] + prevRow[j]; // get the j + 1 value which is 1 for last col add Previous Row at index j col value
       }
       prevRow = currRow;
     }
    return prevRow[0];
  }
  public int UniquePathUsingMemoization(int row, int col){
    if(row == 0 && col == 0)
      return 0;
    int [][] cache = new int[row][col];
    return helperDfs(cache, row, col, 0, 0);
  }
  private int helperDfs(int [][]cache, int row, int col, int r, int c){
    if(r == row || c == col)
      return 0;
    if(cache[r][c] != 0)
      return cache[r][c];
    if(r == row - 1 && c == col - 1) // reached the last cell return 1
      return 1;
    cache[r][c] = helperDfs(cache, row, col, r + 1, c) + helperDfs(cache, row, col, r, c + 1);
    return cache[r][c];
  }
}

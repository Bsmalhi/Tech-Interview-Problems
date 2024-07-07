class NQueens{
  public List<List<String>> solveQueens(int n){
    List<List<String>> result = new ArrayList<>();
    queens(new boolean[n][n], result, 0);
    return result;
  }
  private void queens(booleans[][] board, List<List<String>> result, int row){
    if(row == board.length){
      List<String> ans = new ArrayList<>();
      createBoard(board, ans);
      result.add(ans);
      return;
    }
    for(int col = 0; col < board.length; col++){
      board[row][col] = true;
      queens(board, result, row);
      board[row][col] = false;
    }
  }
  //Create the board with Q for placing queen and '.' for empty spaces
  private void createBoard(boolean[][] board, List<String> ans){
    for(int i = 0, i < board.length; i++){
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j]){
          sb.append("Q");
        } else {
          sb.append(".");
        }
      }
      ans.add(sb.toString());
    }
  }
  private boolean isSafe(boolean[][] board, int row, int col){
    // check coloumn if safe to place queen
    for(int i = 0; i < row; i++){
      if(board[i][col])
        return false;
    }
    // check bottom up right to left diagnol \ if safe to place queen
    int maxLeft = Math.min(row, col); // we can only go minimum of row/col up otherwise out of bounds
    for(int i = 1; i <= maxLeft; i++){
      if(board[row - i][col - i]) // goes diagonal
        return false;
    }
    // check bottom up left to right diagonal /
    int maxRight = Math.min(row, board.length - 1 + col);
    for(int i = 1; i <= maxRight; i++){
      if(board[row - i][col + 1])
        return false;
    }
    return true;
  }
}

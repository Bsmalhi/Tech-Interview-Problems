class SetMatrixZeros{
  /*
  This solution uses only O(1) space and no copy matrix to check which row or col is 0
  */
  public void setZeros(int [][] matrix){
    int row = matrix.length, col = matrix[0].length;
    boolean firstRowZero = false;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        if(matrix[i][j] == 0){ // current cell 0 the mark subsequence top row and leftmost col = 0 
          matrix[0][j] = 0; // mark top row 0
          if(i == 0){
            firstRowZero = true;
          } else {
            matrix[i][0] = 0; // mark leftmost col 0
          }
        }
      }
    }
    for(int i = 1; i < row; i++){
      for(int j = 1; j < col; j++){
        if(matrix[0][j] == 0 || matrix[i][0] == 0){
          matrix[i][j] = 0;
        }
      }
    }
    if(matrix[0][0] = 0){
      for(int i = 0; i < row; i++){
        matrix[i][0] = 0;
      }
    }
    if(firstRowZero){
      for(int i = 0; i < col; i++){
        matrix[0][i] = 0;
      }
    }
  }
}

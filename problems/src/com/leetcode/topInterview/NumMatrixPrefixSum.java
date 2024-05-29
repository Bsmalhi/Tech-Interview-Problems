class NumMatrix {
    private int [][] matrixSum;
    public NumMatrix(int[][] matrix) {
      int row = matrix.length, col = matrix[0].length;
      // added extra row and col to compute the prefix sum from previous row and col
      matrixSum = int [row + 1][col + 1];
      for(int r = 0; r < row; r++){
        for(int c = 0; c < col; c++){
          matrixSum[r+1][c+1] = matrixSum[r+1][c] + matrixSum[r][c+1] - matrixSum[r][c] + matrix[r][c];
        }
      }
    }
    public int NumMatrixSum(int row1, int col1, int row2, int col2) {
      return matrixSum[row2][col2] + matrixSum[row1][col1] - matrixSum[row2+1][col1] - matrixSum[row1][col2+1];
    }
  
}

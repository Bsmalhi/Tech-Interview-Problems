class ToeplitzMatrix{
  /**
    Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
    A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
    matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
     */
    public boolean isToeplitzMatrix(int[][] matrix) {

        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                if(i > 0 && j > 0 && matrix[i - 1][j - 1 ] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}

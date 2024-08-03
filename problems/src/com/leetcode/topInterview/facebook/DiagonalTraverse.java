class DiagonalTraverse {
    /**
    Given m x n matrix return array of all elements of array in diagonal order
    Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,4,7,5,3,6,8,9]
     */
    public int[] findDiagonalOrder(int[][] mat) {
        // Check for empty matrices
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int row = mat.length, col = mat[0].length;
        int[] result = new int[row*col];
        int k = 0; // ptr for populating result arr
        List<Integer> intermediateList = new ArrayList<>(); // to store diagonal in every iteration
        for(int i = 0; i < row + col - 1; i++){
          intermediateList.clear();

          // first row and last col is the starting point of every diagonal
          int r = i < col ? 0 : i - col + 1; // r is first row until i < 0 otherwise i - col + 1 is our starting row
          int c = i < col ? i : col - 1; // if i > col then shift starting point c to last col

          // to capture elements diagonally we increment row down and col shift to left
          while(r < row && c >= 0){
            intermediateList.add(mat[r][c]);
            r++;
            c--;
          }
          // if i is even we need to reverse list to fully comply with problem of traversing diaganolly
          if(i % 2 == 0){
            Collections.reverse(intermediateList);
          }
          for(int n : intermediateList)
            result[k++] = n;
        }
      return result;
    }
}

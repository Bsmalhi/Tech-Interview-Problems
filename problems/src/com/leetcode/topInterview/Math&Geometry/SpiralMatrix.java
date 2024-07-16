class SpiralMatrix{
  //Given an m x n matrix of integers matrix, return a list of all elements within the matrix in spiral order.
     public List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> result = new ArrayList<>();
       int left = 0, right = matrix[0].length;
       int top = 0, bottom = matrix.length;
       while(left < right && top < bottom){
         for(int i = left; i < right; i++){ // rotate top left row to right
           result.add(matrix[top][i];
         }
         top += 1;
         for(int i = top; i < bottom; i++){
           result.add(matrix[i][ right - 1]);
         }
         right -= 1;
         if(top > bottom || left > bottom)
           break;
         for(int i = right - 1; i > left - 1; i--)
           result.add(matrix[bottom - 1][i];
         bottom -= 1;
         for(int i = bottom - 1; i > top - 1; i--)
           result.add(matrix[i][left]);
         left += 1;
       }
       return result;
     }
}

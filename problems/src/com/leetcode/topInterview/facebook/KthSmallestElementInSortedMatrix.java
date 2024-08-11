class Solution {
    /**
    n x n matrix sorted in ascending order, return the kth smallest element in the matrix.
    find a solution with memory complexity better than O(n^2) 
     */
    public int kthSmallest(int[][] matrix, int k) {
     Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]); // pair of value, row, col
        // so we iterate only min of k rows and add the first element to 
        // start comparing with to find kth smallest element in matrix
      for(int i = 0; i < Math.min(matrix.length, k); i++){
        minHeap.offer(new int[]{matrix[i][0], r, 0});
      }
      int[] minElement = null;
      // we only compare k elements to find the kth smallest in sorted 2d matrix
      while(k-- > 0){
        minElement = minHeap.poll();
        int r = minElement[1], c = minElement[2];
        if(c < matrix.length - 1)
          minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1);
      }
      return minElement[0];
    }
}

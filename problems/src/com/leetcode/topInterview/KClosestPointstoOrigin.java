class KClosestPointstoOrigin{
      /*
    1. Make a max heap of k and calculate the Euclidean distance of each xy plane 
    2. add the point to heap if heap.size() > k heap.poll removing the max value from maxHeap
    3. return result[][] arr with k elements from maxHeap
    */
    public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> 
      Integer.compare(
        (b[0] * b[0] + b[1] * b[1]),
        (a[0] * a[0] + a[1] * a[1])
      )
    );
      for(int[][] point: points){
        pq.offer(point);
        if(pq.size() > k)
          pq.poll();
      }
      int [][] result = new result[k][points[0].length];
      int index = 0;
      while(index < k){
        result[index++] = pq.poll();
      }
      return result;
    }
}

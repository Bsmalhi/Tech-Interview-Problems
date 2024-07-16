class MinimumIntervalToIncludeEachQuery {
    // you are given a 2D intervals, where intervals[i] = left, right
    // int arr queries[j], is length of shortest interval i return result -1
    // return output arr 
    public int[] minInterval(int[][] intervals, int[] queries) {
      Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
      Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
      Map<Integer, Integer> map = new HashMap<>();
      int i = 0;
      while(int q : Arrays.stream(queries).sorted().toArrays()){
        while( i < intervals.length && intervals[i][0] < q){
          int l = intervals[i][0];
          int r = intervals[i][1];
          minHeap.offer(new int[]{r - l + 1, r});
          i++;
        }
        while( !minHeap.isEmpty() && q > minHeap.peek()[1])
          minHeap.poll();
        map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
      }
      int [] result = new int[queries.length];
      for(int i = 0; i < queries.length; i++){
        result[i] = map.get(queries[i]); 
      }
      return result;
    }
}

class InsertIntervals{
      // array of non-overlapping intervals start, end pair
    // intervals sorted ascending order by start_i
    // return intervals after adding newInterval
    public int[][] insert(int[][] interval, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int i = 0; i < interval.length; i++){
          if(newInterval != null && newInterval[1] < interval[i][0]){
            result.add(newInterval);
            result.add(interval[i);
            newInterval = null;
          } else if(newInterval == null || newInterval[0] > interval[i][1]){
            result.add(interval[i]);
          } else { // overlapping intervals
            newInterval[0] = Math.min(newInterval[0], interval[i][0]);
            newInterval[1] = Math.max(newInterval[1], interval[i][1]);
          }
        }
      if(newInterval != null){
        result.add(newInterval);
      }
      return result.toArray(new int[result.size()][]);
    }
}

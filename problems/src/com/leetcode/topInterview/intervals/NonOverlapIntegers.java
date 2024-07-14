class NonOverlapIntegers {
    // given an array of intervals
    // return min number of intervals u need to remove to make rest of intervals non overlapping
    public int eraseOverlapIntervals(int[][] intervals) {
       if(intervals.length <= 1)
         return 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
      int minCount = 0;
      int prevEnd = intervals[0][1];
      for(int i = 1; i < intervals.length; i++){
        if(intervals[i][0] >= prevEnd){ // non-overlapping update prevEnd
          prevEnd = intervals[i][1];
        } else { // overlapping
          minCount++;
          prevEnd = Math.min(prevEnd, intervals[i][1]); // keeping the minimum prevEnd ensures that we only remove minimum intervals from intervals list
        }
      }
      return minCount;
    }
}

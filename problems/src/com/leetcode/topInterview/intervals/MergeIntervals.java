class MergeIntervals {
    // given an array of intervals
    // merge all overlapping intervals eg. [1, 2] & [2, 3]
    // return an non-overlapping interval eg [1, 2] & [3, 4]
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        List<int[]> intervals = new ArrayList<>();
        Arrays.sort(intervals -> Integer.compare(a[0], b[0]);
        for(int i = 0; i < intervals.length; i++){
          if(result.isEmpty() || result.get(result.size() - 1)[1] < intervals[i][0]) // non overlapping
            result.add(intervals[i]);
          else {
            result.add(result.get(result.size() - 1)[1] = Math.max(result.add(result.get(result.size() - 1)[1], intervals[i][1]);
          }
        }
      return result.toArray(new int[result.size()][]);
    }
}

class MinCostForTickets {
    // planned one year advance train traveling
    // days of year in which you travel are int[] days
    // day is an integer from 1 to 365
    // train tickets are sold in 3 ways
    // 1 day pass is sold for costs[1], 7 day pass costs[1], 30 day pass = costs[2]

    /*
        Unbounded knapsack problem where you try to calculate at particular day 
        should we include current costs[i] or not to return the minCost
        Need to keep extra dayPass arr ={1,7,30} to calculate the next day after choose correct pass
    */
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> cache = new HashMap<>();
        int[] dayPass = {1,7, 30};
        return dfs(0, days, costs, cache, dayPass);
    }
  private int dfs(int i, int [] days, int [] costs,  Map<Integer, IntegeR> cache, int[] dayPass){
    if(i == days.length)
      return 0;
    if(cache.containsKey(i))
      return cache.get(i);
    int minCost = Integer.MAX_VALUE;
    for(int j = 0; j < dayPass.length; j++){
      int nextIndex = i;
      while(nextIndex < days.length && days[nextIndex] < days[i] + dayPass[j]){
        nextIndex++;
      }
      minCost = Math.min(minCost, dfs(nextIndex, days, costs, cache, dayPass);
    }
    cache.put(i, minCost);
    return cache.get(i);
  }
}

class Knapsack {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int M = profit.size(), N = capacity;
        int [][] cache = new int[M+1][N+1];
        for(int i = 0; i < cache.length; i++){
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, profit, weight, capacity, cache);
    }
    private int dfs(int i,List<Integer> profit, List<Integer> weight,int capacity,int[][] cache){
        if(i == profit.size())
            return 0;
        if(cache[i][capacity] != -1)
            return cache[i][capacity];
        // skip the item
        cache[i][capacity] = dfs(i + 1, profit, weight, capacity, cache);
        // include the item
        int newCap = capacity - weight.get(i);
        if(newCap >= 0){
            int p = profit.get(i) + dfs(i + 1, profit, weight, newCap, cache);
            // compute max profit
            cache[i][capacity] = Math.max(cache[i][capacity], p);
        }
        return cache[i][capacity];
    }
}

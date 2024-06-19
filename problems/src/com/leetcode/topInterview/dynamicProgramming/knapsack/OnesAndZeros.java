class OnesAndZeros {
  // without recursion DP 2d array problem
      public int findMaxForm(String[] strs, int m, int n) {
        // Initialize a 2D DP array to store the maximum number of strings that can be formed
        int[][] dp = new int[m + 1][n + 1];
        
        // Iterate over each string in the input array
        for (String s : strs) {
            int countM = countZeros(s);
            int countN = countOnes(s);

            // Update the DP array from bottom right to top left to avoid overwriting values prematurely
            for (int i = m; i >= countM; i--) {
                for (int j = n; j >= countN; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - countM][j - countN]);
                }
            }
        }
        
        return dp[m][n];
    }
  public int findMaxForm(String[] strs, int m, int n){
    Map<String, Integer> cache = new HashMap<>();
    return dsf(0, strs, m, n, cache);
  }
  private int dfs(int i, String[] strs, int m, int n, Map<String, Integer> cache){
    if(i == strs.length)
      return 0;
    String key = i + "-" + m + "-" + n;
    if(cache.containsKey(key))
      return cache.get(key);
    int countM = countZeros(strs[i]), countN = countOnes(strs[i]);
    //exclude current string
    int exclude = dfs(i+1, strs, m, n, cache);
    // include current string if possible
    int include = 0;
    if(countM <= M && countN <= n){
      include = dfs(i + 1, strs, m - countM, n - countN, cache));
    }
    // enter the max of any
    cache.put(Math.max(include, exclude); 
    return cache.get(key);
  }
      private int countZeros(String strs){
        int count = 0;
        for(char c: strs.toCharArray()){
            if(c == '0')
                count++;
        }
        return count;
    }
    private int countOnes(String strs){
        int count = 0;
        for(char c: strs.toCharArray())
            if(c == '1')
                count++;
        return count;
    }
}

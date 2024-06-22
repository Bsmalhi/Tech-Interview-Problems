class LowestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int result = 0;
        int[][] cache = new int[text1.length() + 1][text2.length() + 1];
        for(int [] arr: cache)
            Arrays.fill(arr, -1);
        return dfs(0, 0, text1, text2, cache);
    }
    private int dfs(int i , int j, String text1, String text2, int[][] cache){
        if(i == text1.length() || j == text2.length())
            return 0;
        if(cache[i][j] !=  -1)
            return cache[i][j];
        if(text1.charAt(i) == text2.charAt(j))
            cache[i][j] = 1 + dfs(i + 1, j + 1, text1, text2, cache);
        else
            cache[i][j] = Math.max(dfs(i + 1, j, text1, text2, cache), dfs(i, j + 1, text1, text2, cache));
        return cache[i][j];
    }
    // iterative 2d dp array faster runtime 
    public int longestCommonSubsequence2(String text1, String text2) {
        int result = 0;
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = text1.length() - 1; i >= 0;  i--){
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}

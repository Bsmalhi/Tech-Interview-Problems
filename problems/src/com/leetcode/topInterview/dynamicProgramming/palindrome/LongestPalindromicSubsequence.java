class LongestPalindromicSubsequence{
  public int longestPalindromeSubseq(String s) {
        int [][] cache = new int[s.length() + 1][s.length() + 1];
        for(int[] arr : cache)
            Arrays.fill(arr, -1);
        return dfs(0, s.length() -1, s, cache);
  }
  private int dfs(int left, int right, String s, int[][] cache ){
    if( left > right)
        return 0;
    if(left == right) // both are pointing to same char so just one palindrome
      return 1;
    if(cache[left][right] != -1)
      return cache[left][right];
    if(s.charAt(left) == s.charAt(right)){
      cache[left][right] = 2 + dfs(left + 1, right - 1, s, cache);
    } else {
      cache[left][right] = Math.max(dfs(left + 1, right, s, cache), dfs(left, right - 1, s, cache));
    }
    return cache[left][right];
  }
}

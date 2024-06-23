class EditDistance {
      public int minDistance(String word1, String word2) {
        if(word1.length == 0)
          return word2.length(); // this is how much min oper required distance
        if(word2.length == 0)
          return word1.length();
        int[][] cache = new int[word1.length() + 1][word2.length() + 1];
        for(int [] arr: cache)
          Arrays.fill(arr, -1);
        return dfs(0, 0, word1, word2, cache); 
      }
  private int dfs(int i, int j, String word1, String word2, int[][] cache) {
    if(i == word1.length())
      return word2.length() - j;
    if(j == word2.length())
      return word1.length() - i;
    if(cache[i][j] != -1)
      return cache[i][j];
    if(word1.charAt(i) == word2.charAt(j))
      cache[i][j] = dfs(i + 1, j + 1, word1, word2, cache);
    else {
      int insert = 1 + dsf(i, j + 1, word1, word2, cache);
      int delete = 1 + dfs(i + 1, j, word1, word2, cache);
      int replace = 1 + dfs(i + 1, j + 1, word1, word2, cache);
      cache[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    return cache[i][j];
  }
}

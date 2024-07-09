class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
       Boolean [] cache = new Boolean[s.length()];
      return dfs( s, wordDict, 0, cache);
    }
    private boolean dfs(String s, List<String> wordDict, int start, Boolean [] cache){
      if(start == s.length())
        return true;
      if(cache[start] != null){
        return cache[start];
      }
      for(String word: wordDict){
        int end = start + word.length();
        if(end <= s.length() && s.substring(start, end).equals(word))
          if(dfs(s, wordDict, end, cache){
            cache[start] = true;
            return true;
          }
      }
      cache[word] = false;
      return false;
    }
}

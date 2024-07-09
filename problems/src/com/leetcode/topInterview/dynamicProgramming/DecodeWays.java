class DecodeWays{
    // it involves choosing between decoding one digit or two digits at a time, given certain conditions.
    public int numDecodings(String s) {
      Map<Integer, Integer> cache = new HashMap<>(); // length of s and num of ways pair
      cache.put(s.length(), 1); // whole s len is always a way or could be empty that is also a num of way
      return dfs(s, 0, cache);
    }
  private int dfs(String s, int i, Map<Integer, Integer> cache){
    if(cache.containsKey(i))
      return cache.get(i);
    if(s.charAt(i) == '0')
      return 0;
    int res = dfs(s, i + 1, cache);
    if(i + 1 < s.length() && s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')
      res += dfs(s, i + 2, cache); // as we are including 2 chars at this step
    cache.put(i, res);
    return res;
  }
}

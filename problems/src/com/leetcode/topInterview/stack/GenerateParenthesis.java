class GenerateParenthesis{
  // solve using backtracking add open bracket then add close bracket if open == close add to result
  public List<String> generateParenthesis(int n){
    List<String> result = new ArrayList<>();
    dfs(0, 0, n, "", result);
    return result;
  }
  private void dfs(int open, int close, int n, String s, List<String> result){
    if(n == close && open == close){
      result.add(s);
      return;
    }
    if(open < n)
      dfs(open + 1, close, n, s + "(", result);
    if(close < open)
      dfs(open, close + 1, n, s + ")", result);
    }
  }
}

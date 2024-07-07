class PalindromicSubstring{
  public List<List<String>> palindromicSubstring(String word){
    List<List<String>> result = new ArrayList<>();
    dfs(word, 0, result, new ArrayList<>());
    return result;
  }
  private void dfs(String word, int start, List<List<String>> result, List<String> list){
    if( start == word.length()){
      result.add(new ArrayList<>(list));
      return;
    }
    for(int end = start + 1; end <= word.length; end++){
      if(isPalindrome(word, start, end - 1){
        list.add(word.substring(start, end);
        dfs(word, end, result, list);
        list.remove(list.size() - 1);
      }
    }
  }
  private boolean isPalindrome(String word, int start, int end){
    for(start < end){
      if(word.charAt(start) != word.charAt(end))
          return false;
      start++;
      end--;
    }
    return false;
  }
}

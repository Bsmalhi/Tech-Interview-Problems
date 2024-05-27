class LongestSubstringWithoutDuplicates{
  public int longestSubstring(String s){
      int l = 0, maxLength = 0;
      Set<Character> set = new HashSet<>();
      for(int i = 0 ; i < s.length(); i++){
        while(set.contains(s.charAt(i))){
          set.remove(s.charAt(l));
          l++;
        }
        set.add(s.charAt(i));
        maxLength = Math.max(maxLength, i - l + 1);
      }
     return maxLength;
  }
}

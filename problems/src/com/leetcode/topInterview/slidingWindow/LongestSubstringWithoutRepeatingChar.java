class LongestSubstringWithoutRepeatingChar{
  /*
  Given a string s, find the length of the longest substringwithout repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
  */
  public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int left = 0, maxLen = 0;
    for(int right = 0; right < s.length(); i++){
      if(set.contains(s.charAt(right)){
        set.remove(s.charAt(left));
        left = left + 1;
      }
      set.add(s.charAt(right));
      maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
  }
}

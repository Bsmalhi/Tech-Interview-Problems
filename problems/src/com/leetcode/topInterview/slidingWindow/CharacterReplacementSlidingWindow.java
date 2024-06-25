class CharacterReplacementSlidingWindow {
  /*
  You are given a string s and an integer k. You can choose any character of the string and 
  change it to any other uppercase English character. You can perform this operation at most k times.
  Return the length of the longest substring containing the same letter you can get after performing 
  the above operations.
  Input: s = "ABAB", k = 2
  Output: 4
  Explanation: Replace the two 'A's with two 'B's or vice versa.
  */
    public int characterReplacement(String s, int k) {
      Map<Character, Integer> map = new HashMap<>();
      int l = 0, longestSubstring = 0, maxCharCount;
      for(int r = 0; r < s.length(); r++){
        int maxCharCount = Math.max(maxCharCount, map.getOrDefault(s.charAt(r), 0) + 1);
        map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
        int subStringLength = r - l + 1;
         // meaning not possible to replace a single char to generate a substring of same length in current substring
        if(subStringLength - maxCharCount > k){ 
          map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
          l++;
        }
        longestSubstring = Math.max(longestSubstring, r - l + 1);
      }
      return longestSubstring;
    }
}

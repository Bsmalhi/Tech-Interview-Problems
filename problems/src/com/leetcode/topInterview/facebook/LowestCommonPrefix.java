class LowestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
       if(strs.length == 0)
         return "";
      String result = strs[0];
      for(int i = 1; i < strs.length; i++){
        while(strs[i].indexOf(result) != 0) // index 0 signifies that the result is found
          result = result.substring(0, result.length() - 1);
      }
      return result;
    }
}

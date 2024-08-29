class MinAddToMakeParanthesisValid {
    /**
    Paranthesis string is valid if and only if 
    a) it is empty b) it can be written as AB where A and B are valid strings
    Example 1:
    Input: s = "())"
    Output: 1
    
    Example 2:
    Input: s = "((("
    Output: 3
     */
    public int minAddToMakeValid(String s) {
      if(s.length() == 0)
        return 0;
      int bal = 0, minMove = 0;
      for(char c : s.toCharArray()){
        bal += c == '(' ? 1 : -1; // a string is valid if its balance is 0
        if(bal == -1){
          minMove++;
          bal++;
        }
      }
      return minMove + bal;
    }
}

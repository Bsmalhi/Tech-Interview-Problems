class MinimumRemoveToMakeValidParentheses{
    // remove min no. of paranthesis in any position to return valid string
    // conditions for valid string
    // it is empty String contains only lowercase characters
    // AB -> (A B) or (A ..... B)
  // solution using 2 pass s
    public String minRemoveToMakeValid(String s) {
      Set<Integer> indexesToRemove = new HashSet<>();
      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < s.length(); i++){
        if(s.charAt(i) == '('){
          stack.push(i);
        }
        if(s.charAt(i) == ')'){
          if(stack.isEmpty())
            indexesToRemove.add(i);
          else
            stack.pop();
        }
      }
      while(!stack.isEmpty()) // add all the remaining indexes from stack
        indexesToRemove.add(stack.pop());
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length(); i++){
        if(!indexesToRemove.contains(i))
          sb.append(s.charAt(i));
      }
      return sb.toString();
    }
}

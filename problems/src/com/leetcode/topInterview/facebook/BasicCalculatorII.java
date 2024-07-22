class Solution {
    /*
    given String s "3+2*2" evaluate this expression and returns its value
    expression could contain +, -, *, / 
    we have to always calculate * and / operations before + & - operation 
    so whenever + or - put currNum in stack & whenever * or / operation evaluate expression and push to stack
    */
    public int calculate(String s) {
      if(s.length() || s == null)
          return 0;
      char operation = '+';     
      int currNum = 0;
      Stack<Integer> stack = new Stack<>();
      for(int i = 0; i < s.length(); i++){
        char currentChar = s.charAt(i);
        if(Character.isDigit(currentChar)){
          currNum *= 10;
          currNum += currentChar;
        }
        if(!Character.isDigit(currentChar) && !Character.isWhitespace() || i == s.length() - 1){
          if(operation == '+'){
            stack.push(currentNum);
          }else if(operation == '-'){
            stack.push(-currentNum);
          } else if(operation == '*'){
            stack.push(stack.pop() * currentNum);
          } else if(operation == '/'){
            stack.push(stack.pop() / currentNum);
          }
          operation = currentChar;
          currNum = 0;
        }
      }
      int result = 0;
      while(!stack.isEmpty()){
        result += stack.pop();
      }
      return result;
    }
}

class Solution {
  /*
  Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
  Example 1:
  Input: s = " 2-1 + 2 "
  Output: 3
  
  Example 2:
  Input: s = "(1+(4+5+2)-3)+(6+8)"
  Output: 23
  */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0; // for ongoing result
        int sign = 1; // 1 means positive, -1 means negative
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');
            } else if(ch == '+'){
                result += sign * operand;
                sign = 1;
                //reset operand
                operand = 0;
            } else if(ch == '-'){
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                //Reset operand and result, as if new evaluation begins for new sub-expression
                sign = 1;
                result = 0;
            } else if(ch == ')'){
                // evaluate expression to the left with result, sign and operand.
                result += sign * operand;
                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();
                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();
                //reset operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}

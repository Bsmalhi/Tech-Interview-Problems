class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            } else if( token.equals("-")){
                int num1 = stack.pop(), num2 = stack.pop();
                stack.push(num2 - num1);
            } else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(token.equals("/")){
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2/n1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}

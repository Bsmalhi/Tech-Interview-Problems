class ValidParenthesis{
    public boolean isValid(String s) {
        if(s.length() < 1)
            return true;
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;
                char b = stack.peek();
                if(b == '(' && c == ')'){
                    stack.pop();
                } else if (b == '{' && c == '}' ){
                    stack.pop();
                } else if (b == '[' && c == ']'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

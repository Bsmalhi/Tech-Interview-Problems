class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
  
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
      stack.push(val);
    }
    
    public void pop() {
        int temp = stack.pop();
      if(!minStack.isEmpty() && temp == minStack.peek())
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if (stackMin.isEmpty())
            return 0;
        return minStack.peek();
    }
}

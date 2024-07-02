class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int [] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            // just need to check if prevday stack.peek() < temp at i then update the res at prevday
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevDay = stack.pop();
                res[prevDay] = i - prevDay; 
            }
            stack.push(i);
        }
        return res;
    }
}

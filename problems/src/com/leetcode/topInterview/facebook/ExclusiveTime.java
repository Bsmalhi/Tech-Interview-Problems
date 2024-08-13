class ExclusiveTime {
    /**
    For example, "0:start:3" means a function call with function ID 0 started at the beginning 
    of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of 
    timestamp 2. Note that a function can be called multiple times, possibly recursively.
    Return the exclusive time of each function in an array, where the value at the ith index 
    represents the exclusive time for the function with ID i.
    Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    Output: [3,4]
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int[n];
        Stack<Event> stack = new Stack<>();
      for(String log: logs){
        Event event = new Event(log);
        if(event.isStart){
          stack.push(event);
        } else {
          Event startEvent = stack.pop();
          int duration = event.timestamp - startEvent.timestamp + 1;
          result[startEvent.funcId] += duration;
          /* 
              as the previous func was a nested call inside another call and 
              outer func didn't actually use this time so we substract current 
              duration from func at top of stack
          */
          if(!stack.isEmpty()){
            result[stack.peek().funcId] -= duration;
          }
        }
      }
      return result;
    }
  class Event{
    int funcId;
    boolean isStart;
    int timestamp;
    public Event(String log){
      String logStr = log.split(":");
      this.funcId = Integer.parseInt(logStr[0]);
      this.isStart = logStr[1].equals("start");
      this.timestamp = Integer.parseInt(logStr[2]);
    }
  }
}

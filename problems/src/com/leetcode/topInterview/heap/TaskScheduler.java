class TaskScheduler{
  // we are given a arr of tasks with tasks[i] is uppercase A to Z tasks
  // identical tasks need to be separated by n time
  // return minimum no. of CPU cycles needed to complete tasks
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> tasksCountMap = new HashMap<>();
    for(char task: tasks)
      tasksCountMap.put(task, tasksCountMap.get( task, 0) + 1);
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    maxHeap.addAll(tasksCountMap.values());
    Deque<int[]> queue = new Deque<>(); // pair of cnt, idleTime. 
    int time = 0; // to keep track of all time taken by CPU cycles

    // with each iteration we check if curr time >= idleTime from queue 
    // if it is then process the task count by pushing in maxHeap then poll count &
    // decrement count then store in queue again with updated idletime = time + n + 1;
    while(!maxHeap.isEmpty() || !queue.isEmpty()){
      if(!queue.isEmpty() && time >= queue.peek()[1])
        maxHeap.offer(queue.poll()[0]);
      if(!maxHeap.isEmpty()){
        int cnt = maxHeap.poll() - 1;
        if(cnt > 0)
          queue.offer(new int[]{cnt, time + n + 1}); 
      }
      time++; // increase curr time after each iteration
    }
    return time;
  }
}

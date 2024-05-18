class KthLargest {
    /*
    1. So need to write a min heap priority queue with only k elements at any time.
    2. kth largest element will be the minimum element in min heap at top so heap.peek()
    3. from constructor call add(val) if(pq.size() < k){ pq.offer(val) else if ( val > pq.peek()) pq.poll(); pq.offer(val)
    */
    PriorityQueue<Integer> pq = null;
    int k = 0;
    public KthLargest(int k, int[] nums) {
      pq = new PriorityQueue<>();
      this.k = k;
      for (int i = 0; i < nums.length; i++){
          add(nums[i]);
      }
    }
    private int add(int num){
        if(pq.size() < k){ 
            pq.offer()
        } else if(pq.peek() < num){ // I have to limit pq size to top 3 elements only
            pq.poll();
            add(num);
        }
        return pq.peek();
    }
}

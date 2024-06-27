class TopKFrequentInList{
  public int[] topKFrequent(int [] nums, int k){
    Map<Integer, Integer> map = new HashMap<>();
    for(int n: nums)
      map.put(n, map.getOrDefault(n, 0) + 1);
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      pq.offer(entry);
      if(pq.size() > K)
        pq.poll(); // remove min element from minHeap
    }
    int i = 0;
    int[] arr = new int[k];
    while(k > 0){
      arr[i++] = pq.poll().getKey();
      k--;
    }
    return arr;
  }
}

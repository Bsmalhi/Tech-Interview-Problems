class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
      if(stones.length == 1)
        return stones[0];
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int num: stones)
        pq.offer(-num);           // to convert to max heap bcoz On each turn, we choose the heaviest two stones and smash them together
      while(pq.size() != 1){
        int a = pq.poll();
        int b = pq.poll();
        if(a != b)
          pq.offer(Math.abs(a - b));
      }
      return pq.size() == 0 ? 0 : -pq.poll();
    }
}

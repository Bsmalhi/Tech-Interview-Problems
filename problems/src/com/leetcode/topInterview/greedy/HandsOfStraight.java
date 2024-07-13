class HandsOfStraight{
      // arr hand where hand[i] is value written on ith card
    // and an integer groupsize
    // rearrange cards into groups so that each group if of size groupsize
    // cards values are consecutively increasing by 1 in groups
    public boolean isNStraightHand(int[] hand, int groupSize) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int n: hand){
        map.put(n, map.getOrDefault(n, 0) + 1);
      }
      Queue<Integer> minHeap = new PriorityQueue<>(map.keySet()); // to track min starting hand for creating groups
      while(!minHeap.isEmpty()){
        int first = minHeap.peek();
        for(int i = first; i < first + groupSize; i++){
          if(!map.containsKey(i)){
            return false;
          }
          map.put(i, map.get(i) - 1);
          if(map.get(i) == 0){
            if(i != minHeap.peek()) // we cannot form a group if i's count in map is zero and i != minHeap.peek() which is first we started from
              return false;
            minHeap.poll();
          }
        }
      }
      return true;
    }
}

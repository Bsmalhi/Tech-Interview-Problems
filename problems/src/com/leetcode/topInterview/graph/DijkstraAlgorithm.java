class DijkstraAlgorithm{
  public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
    Map<Integer, Integer> shortestPathMap = new HashMap<>();
    List<List<int[]>> adjList = new ArrayList<>();
    for(int i = 0; i < n; i++){
      adjList.add(new ArrayList<>());
    }
    for(List<Integer> edge: edges){
      int src = edge.get(0);
      int dst = edge.get(1);
      int weight = edge.get(2);
      adjList.get(src).add(new int[]{dst, weight});
    }
    Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    minHeap.offer(new int[]{0, src}); // weight, neigbhor
    while(!minHeap.isEmpty()){
      int[] temp = minHeap.poll();
      int n1 = temp[1], w1 = temp[0];
      if(shortestPathMap.containsKey(n1))
        continue;
      shortestPathMap.put(n1, w1);
      for(int[] neighbor: adjList.get(n1)){
        int n2 = neigbor[0], w2 = neigbor[1];
        if(!shortestPathMap.containsKey(n2))
          minHeap.offer(new int[]{n2, w1+w2});
      }
    }
    for(int i = 0; i < n; i++){
      if(!shortestPathMap.containsKey(i)){
        shortestPathMap.put(i, -1);
      }
    }
    return shortestPathMap;
  }
}

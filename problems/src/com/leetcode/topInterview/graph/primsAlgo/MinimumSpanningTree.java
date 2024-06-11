class MinimumSpanningTree{
  public int minimumSpanningTree(List<List<Integer>> edges, int n) {
    List<List<int[]>> adjList = new ArrayList<>();
    int mst = 0;
    Set<Integer> visited = new HashSet<>();
    for(int i =0; i < n;i++)
      adjList.add(new ArrayList<>());
    for(List<Integer> edge: edges){
      int src = edge.get(0), dst = edge.get(1), weight = edge.get(2);
      adjList.get(src).add(new int[]{dst, weight);
      adjList.get(dst).add(new int[]{src, weight);
    }
    Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    for(int[] node: adjList.get(0)){
      int dst = node[0], weight = node[1]
      minHeap.offer(new int[]{weight, dst});
    }
    visited.add(0);
    while(!minHeap.isEmpty()){
      int [] temp = minHeap.poll();
      int n1 = temp[1], w1 = temp[0];
      if(visited.contains(n1))
        continue;
      visited.add(n1);
      mst += w1;
      for(int[] neighbor: adjList.get(n1)){
        int n2 = neighbor[0], w1 = neighbor[1];
        if(!visited.contains(n2))
          minHeap.offer(new int[]{w1, n2});
      }
    }
    return visited.size() == n ? mst : -1;
  }
}

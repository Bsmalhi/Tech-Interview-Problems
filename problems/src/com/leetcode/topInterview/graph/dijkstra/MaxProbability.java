class MaxProbability{
      public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> undirectedAdjList = new ArrayList<>();
        double[] maxProb = new double[n];
        for(int i = 0; i < n; i++){
          undirectedAdjList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
          int prob = succProb[i];
          undirectedAdjList.get(edges[i][0]).add(new double[]{edges[i][1], prob});
          undirectedAdjList.get(edges[i][1]).add(new double[]{edges[i][0], prob}); // assuming undirected graph
        }
        Queue<double[]> maxHeap = new PriorityQueue<>((a,b) -> {
          return Double.compare(b[0],a[0]);
        });
        maxHeap.offer(new double[]{1, start_node}); // start with 1 as 0 will result in 0 prob result
        while(!maxHeap.isEmpty()){
          double [] temp = maxHeap.poll();
          int n1 = (int) temp[1]; double p1 = temp[0];
          if(n1 == end_node)
            return p1;
          for(double[] neighbor: undirectedAdjList.get(n1)){
            int n2 = (int) neigbor[0]; double p2 = neighbor[1];
            if(p1 * p2 > maxProb[n2]){
              maxProb[n2] = p1 * p2;
              maxHeap.offer(new double[]{maxProb[n2], n2});
            }
          }
        }
        return 0.0
      }
}

class MinCostToConnectAllPoints{
     public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < points.length; i++){
            int x = points[i][0], y = points[i][1];
            for(int j = i + 1; j < points.length; j++){
                int x2 = points[j][0], y2 = points[j][1];
                int cost = Math.abs(x - x2) + Math.abs(y - y2);
                adjList.get(i).add(new int[]{j, cost});
                adjList.get(j).add(new int[]{i, cost});
            }
        }
        int distance = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0,0}); // weight, currNode
        while(!minHeap.isEmpty()){
            int [] temp = minHeap.poll();
            int node = temp[1], cost = temp[0];
            if(visited.contains(node))
                continue;
            distance += cost;
            visited.add(node);
            for(int[] point: adjList.get(node)){
                int node2 = point[0], cost2 = point[1];
                if(!visited.contains(node2)){
                    minHeap.offer(new int[]{cost2, node2});
                }
            }
        }
        return distance;
    }
}

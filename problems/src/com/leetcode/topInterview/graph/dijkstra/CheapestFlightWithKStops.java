class CheapestFlightWithKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int p = flights[i][2];
            adjList.get(s).add(new int[]{d, p});
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // cost, curr airport, stops 
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int c = temp[0];
            int d = temp[1];
            int stop = temp[2];
            if(d == dst)
                return c;
            if(stop > k) // we don't want to process node with stop greater than k
                continue;
            for(int[] neighbor: adjList.get(d)){
                int d2 = neighbor[0];
                int p2 = neighbor[1];
                pq.offer(new int[]{c + p2, d2, stop + 1});
            }
        }
        return - 1;
    }
}

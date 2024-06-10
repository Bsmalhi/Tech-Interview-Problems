class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> netDelayMap = new HashMap<>();
        List<List<int[]>> adjList = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Fill the adjacency list with edges and delays
        for (int[] time : times) {
            int src = time[0];
            int tgt = time[1];
            int delay = time[2];
            adjList.get(src).add(new int[]{tgt, delay});
        }
        
        // Min-heap to process nodes in order of their current known shortest distance
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});
        
        while (!minHeap.isEmpty()) {
            int[] temp = minHeap.poll();
            int t1 = temp[0];
            int n1 = temp[1];
            
            // If node n1 has already been visited, skip it
            if (netDelayMap.containsKey(n1)) {
                continue;
            }
            
            // Mark node n1 as visited with its corresponding delay time t1
            netDelayMap.put(n1, t1);
            
            // Check all neighbors of node n1
            for (int[] neighbor : adjList.get(n1)) {
                int n2 = neighbor[0];
                int t2 = neighbor[1];
                
                // If neighbor n2 has not been visited, add it to the heap
                if (!netDelayMap.containsKey(n2)) {
                    minHeap.offer(new int[]{t1 + t2, n2});
                }
            }
        }
        
        // If not all nodes are reached, return -1
        if (netDelayMap.size() != n) {
            return -1;
        }
        
        // Calculate the maximum delay time
        int networkDelay = 0;
        for (int delay : netDelayMap.values()) {
            networkDelay = Math.max(networkDelay, delay);
        }
        
        return networkDelay;
    }
}

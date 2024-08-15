class MinTimeToCollectAppleInTree {
    /**
    Given undirected tree consisting of n vertices no. from 0 - (n-1)
    You spend 1 sec to walk over one edge of tree. 
    Return min time in seconds you have to collect all apples in tree.
    there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; 
    otherwise, it does not have any apple.
    
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(edges.length == 0)
            return 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return dfs(0, -1, adjList, hasApple);
    }
    private int dfs(int node, int parent, List<List<Integer>> adjList, List<Boolean> hasApple){
        int totaltime = 0;
        for(int neighbor: adjList.get(node)){
            // Without this check, due to undirected graph, DFS would continue looping between the parent and child. 
            if(neighbor == parent)
                continue;
            int childTime = dfs(neighbor, node, adjList, hasApple);
            if(childTime > 0 || hasApple.get(neighbor))
                // + 2 for the roundtrip from parent to node then back to parent time taken
                totaltime += childTime + 2; 
        }
        return totaltime;
    }
}

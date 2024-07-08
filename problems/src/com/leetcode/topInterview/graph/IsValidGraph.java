class IsValidGraph {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {
        if(n == 0 ) return true;
        if(edges.length == 0) return true;
        // build adjList Map in this case usually I would build AdjList
        for(int [] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            map.putIfAbsent(node1, new ArrayList<>());
            map.putIfAbsent(node2, new ArrayList<>());
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(edges[0][0], visited, -1) && visited.size() == n;
    }

    private boolean dfs(int edge, Set<Integer> visited, int prev){
        if(visited.contains(edge)) return false;
        visited.add(edge);
        for(Integer neighbor: map.get(edge)){
            if(prev == neighbor)
                continue;
            if(!dfs(neighbor, visited, edge))
                return false;
        }
        return true;
    }
}

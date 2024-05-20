class Graph {
    Map<Integer, HashSet<Integer>> adjList;
    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src, new HashSet<>());
        adjList.putIfAbsent(src, new HashSet<>());
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(adjList.containsKey(src) && adjList.get(src).contains(dst)){
            adjList.get(src).remove(dst);
            return true;
        }
        return false;
    }

    public boolean hasPath(int src, int dst) {
        return hasPathDFS(src, dst, new HashSet<Integer>());
    }
    private boolean hasPathDFS(int src, int dst, Set<Integer> visited){
        if (src == dst) {
            return true;
        }
        visited.add(src);
        for(int neighbor: adjList.getOrDefault(src, new HashSet<>())){
            if(!visited.contains(neighbor)){
                if(hasPathDFS(neighbor, dst, visited))
                    return true;
            }
        }
        return false;
    }
}

class TopologicalSort{
  public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> topGraph = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        // build adjList
        for(int i = 0; i < n; i++){
          adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
          adjList.get(edges[i][0]).add(edge[i][1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>(); // to check if current iteration of DFS contains cycle we return empty ArrayList
        for(int i = 0; i < n; i++){
          if(!dfs(i , adjList, topGraph, visited, visiting))
             return new ArrayList<>(); // cycle detected return empty list
        }
        Collections.reverse(topGraph);
      return topGraph;
  }
  public boolean dfs(int src, List<List<Integer>> adjList,List<Integer> topGraph,Set<Integer> visited,Set<Integer> visiting){
    if(visited.contains(src))
      return true;
    if(visiting.contains(src))
      return false;      //cycle detected
    visiting.add(src);
    for(int edge: adjList.get(i)){
      if(!dfs(edge, adjList, topGraph, visited, visiting))
        return false; // cycle detected
    }
    visiting.remove(src);
    visited.add(src);
    topGraph.add(src);
    return true; // no cycle detected
  }
}

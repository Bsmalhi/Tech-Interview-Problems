class RedundantConnections{
  public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length + 1];
        int [] rank = new int[edges.length + 1];
      for(int i = 0 ; i < parent.length; i++){
        parent[i] = i;
        rank[i] = 0;
      }
    for(int[] edge: edges){
      if(!union(edge[0], edge[1], parent, rank)
         return new int[]{edge[0], edge[1]);
    }
    return new int[]{};
  }
  public int find(int x, parent){
    int p = parent[x];
    while(p != parent[x]){
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }
  public boolean union(int x, int y, int[] parent, int[] rank){
    int p1 = find(x);
    int p2 = find(y);
    if(p1 == p2)
      return false;
    if(rank[p1] < rank[p2]){
      parent[p1] = p2;
      rank[p2]++;
    } else if(rank[p2] < rank[p1]){
      parent[p2] = p1;
      rank[p1]++;
    } else {
      parent[p2] = p1;
      rank[p1]++
    }
    return true;
  }
}

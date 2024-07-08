class ConnectedComponents{
  public int countConnectedComp(int n, int[][] edges){
    UnionFind uf = new UnionFind(n);
    int count = n;
    for(int [] edge: edges){
      if(uf.union(edge[0],edge[1])
         n--;
    }
    return count;
  }
    class UnionFind{
      int [] parents;
      int [] ranks;
      public UnionFind(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0 ; i < n; i++){
          parents[i] = i;
          ranks[i] = 0;
        }
      }
      public int find(int x){
        int n = parent[x];
        while(n != parent[n]){
          parent[n] = parent[parent[n]];
          n = parent[n];
        }
        return n;
      }
      public boolean union(int x, int y){
        int x = find(x);
        int y = find(y);
        if(x == y)
          return false;
        if(rank[x] < rank[y]){
          parent[x] = y;
          rank[y] += 1;
        } else {
          parent[y] = x;
          rank[x] += 1;
        }
        return true;
      }
    }
}

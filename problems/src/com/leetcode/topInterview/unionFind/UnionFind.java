class UnionFind {
    int [] parent;
    int [] rank;
    public UnionFind(int n){
      this.parent = new int[n];
      this.rank = new int[n];
      for(int i = 0; i < n; i++){
        this.parent[i] = i;
        this.rank[i] = 0; 
      }
    }
  public int findParent(int x){
    int p = parent[x];
    while(p != parent[p]){
      p = parent[parent[p]]; // compression algorithm to reduce time complexity for finding parent
      p = parent[p];
    }
    return p;
  }
  public boolean isSameComponent(int x, int y){
    return find(x) == find(y);
  }
  public boolean union(int y, int x){
    if(isSameComponent(x, y))
      return false;
    int p1 = parent[x];
    int p2 = parent[y];
    if(rank[p1] < rank[p2]){
      parent[p1] = p2;
      rank[p2]++;
    } else if(rank[p2] < rank[p1]){
      parent[p2] = p1;
      rank[p1]++;
    } else {
      parent[p1] = p2;
      rank[p2]++;
    }
    return true;
  }
  // find no. of components meaning parent nodes
  public int findNumOfComponents(){
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < parent.length; i++){
      int p = find(i);
      if(set.contains(p))
        continue;
      set.add(p);
    }
    return set.size();
  }
}

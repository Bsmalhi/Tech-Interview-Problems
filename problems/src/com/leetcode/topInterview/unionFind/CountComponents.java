class CountComponents{
  public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int result = n; // max components can number of edges
        for(int [] edge: edges){
            if(union(edge[0], edge[1], parent, rank) ){
                result--;
            }
        }
        return result;
    }
    public int find(int x, int [] parent){
        int p = parent[x];
        while(p !=  parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public boolean union(int x, int y, int[] parent, int[] rank){
        int p1 = find(x, parent);
        int p2 = find(y, parent);
        if(p1 == p2){
            return false;
        }
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
}

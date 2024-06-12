class kruskalAlgo {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        int mst = 0;
        UnionFind uf = new UnionFind(n);
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(List<Integer> edge: edges){
            int src = edge.get(0), dst = edge.get(1), weight = edge.get(2);
            minHeap.offer(new int[]{weight, src, dst});
        }
        List<int[]> edgeList = new ArrayList<>();
        while(!minHeap.isEmpty()){
            int [] temp = minHeap.poll();
            int src = temp[1], dst = temp[2], weight = temp[0];
            if(uf.union(src, dst)){
                edgeList.add(new int[]{src, dst});
                mst += weight;
            }
        }
        return edgeList.size() == n - 1 ? mst : -1;
    }
    class UnionFind{
        int []parent;
        int [] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }
        public int find(int x){
            while(x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean union(int x, int y){
            x = find(x); 
            y = find(y);
            if(x == y) return false;
            if(rank[x] > rank[y]){
                parent[y] = x;
                rank[x] += 1;
            } else {
                parent[x] = y;
                rank[y] += 1;
            }
            return true;
        }
    }
}

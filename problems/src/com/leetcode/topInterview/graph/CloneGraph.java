class CloneGraph{
  public Node clone(Node node){
    Map<Node, Node> oldToNew = new HashMap<>();
    return dfs(node, oldToNew);
  }
  private Node dfs(Node node, Map<Node, Node> oldToNew){
    if(node == null){
      return node;
    }
    if(oldToNew.containsKey(node)){
      return oldToNew.get(node);
    }
    Node copy = new Node(node.val);
    oldToNew.put(node, copy);
    for(Node n: node.neighbors){
      copy.neighbors.add(dfs(n, oldToNew));
    }
    return copy;
  }
}

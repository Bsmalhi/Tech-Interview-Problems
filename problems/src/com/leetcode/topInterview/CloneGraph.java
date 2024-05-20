class CloneGraph {
  public Node cloneGraph(Node node){
    return helperDfs(node, new HashMap<Node, Node>());
  }
  private int helperDfs(Node node, Map<Node, Node> cloneMap){
    if(node == null)
        return null;
    if(cloneMap.containskey(node.val))
        return cloneMap.get(node.val);
    Node copy = new Node(node.val);
    for(int neighbor: node.neighbors){
      copy.neighbors.add(helperDfs(neighbor, cloneMap));
    }
    return copy;
  }
}

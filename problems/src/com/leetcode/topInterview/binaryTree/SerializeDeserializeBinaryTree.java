class SerializeDeserializeBinaryTree {
  int i;
  public String serialize(TreeNode root){
    List<String> res = new ArrayList<>();
    dfsSerialize(root, res);
    return String.join(",", res);
  }
  private void dfsSerialize(TreeNode root, List<String> res){
    if(root == null){
      res.add("N"); // for null
      return;
    }
    res.add(String.valueOf(root.val)):
    dfsSerialize(root.left, res);
    dfsSerialize(root.right, res);
  }
  public String deserialize(String data){
    String[] vals = data.split(",");
    i = 0
    return dfsDeserialize(vals);
  }
  private void dfsDeserialize(String[] vals){
    String token = vals[i++];
    if(token.equals("N"))
      return null;
    TreeNode root = new TreeNode(Integer.valueOf(token));
    root.left = dfsDeserialize(vals);
    root.right = dfsDeserialize(vals);

    return root;
  }
}

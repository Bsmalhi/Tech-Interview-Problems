class ReconstructItinarary{
  public List<String> findItinarary(List<List<String>> tickets){
    List<String> res = new ArrayList<>();
    Map<String, ArrayList<String>> map = new HashMap<>();
    for(List<String> list: tickets){
      String src = list.get(0);
      String dst = list.get(1);
      map.putIfAbsent(src, new ArrayList<>());
      map.get(src).add(dst);
    }
    for(String key: map.keySet())
      Collections.sort(map.get(key));

    dfs(map, res, "JFK"); // start from JFK airport as mentioned in question
    Collections.reverse(res);
    if(res.size() != tickets.size() + 1){
      return new ArrayList<>();
    }
    return result;
  }
  private void dfs(Map<String, ArrayList<String>> map, List<String> res, String src){
    if(map.containsKey(src)){
      List<String> destinations = new ArrayList<>(map.get(src));
      while(!destinations.isEmpty()){
        String dest = destinations.get(0); // get the first lexographically sorted string
        map.get(src).remove(0);
        dfs(map, res, dest);
        destinations = new ArrayList<>(map.get(src));
      }
    }
    res.add(src);
  }
}

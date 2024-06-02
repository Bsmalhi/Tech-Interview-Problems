class AccountsMerge{
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind dsu = new UnionFind(n);

    Map<String, Integer> emailToAccountMap = new HashMap();
    // iterate over accounts put emails : accountID then union(accountIDexisting, newAcccountId) if email already exists in map
    for(int i = 0; i < n; i++){
      for(int e = 1; e < accounts.get(i).size(); e++){
        int email = accounts.get(i).get(e);
        if(!emailToAccountMap.containsKey(email)){
          emailToAccountMap.put(email, i);
        } else {
          dsu.union(i, emailToAccountMap.get(email));
        }
      }
    }
    //Find parent of account and add to merged map account -> list of emails
    Map<Integer, List<String>> accountEmailGroup = new HashMap<>(); // index of acc -> list of emails
    for(String email: emailToAccountMap.keySet()){
      int account = emailToAccountMap.get(email);
      int leader = dsu.find(account);
      if(!accountEmailGroup.contains(leader)){
        accountEmailGroup.put(leader, new ArrayList<String>());
      }
      accountEmailGroup.get(leader).add(email);
    }
    //get account list of emails sort and add name of account in beginning and add list of email to result
    List<List<String>> res = new ArrayList<>();
    for(int account: accountEmailGroup.keySet()){
      List<String> emails = accountEmailGroup.get(account);
      Collections.sort(emails);
      emails.add(0, accounts.get(account).get(0));
      res.add(emails);
    }
    return res;
}
class UnionFind{
  int [] parents;
  int [] ranks;
  public UnionFind(int n){
    this.parents = new int[n];
    this.ranks = new int[n];
    for(int i = 0; i < n; i++){
      parents[i] = i;
      ranks[i] = 1;
    }
  }
  public int find(int x){
    int p = parents[x];
    while(p != parents[p]){
      parents[p] = parents[parents[p]];
      p = parents[p];
    }
    return p;
  }
  public boolean union(int x, int y){
    int p1 = find(x);
    int p2 = find(y);
    if(p1 == p2)
      return false;
    if(rank[p1] < rank[p2]){
      parents[p1] = p2;
      rank[p2]++;
    } else if(rank[p2] < ranks[p1]){
      parents[p2] = p1;
      rank[p1]++;
    } else {
      parents[p1] = p2;
      ranks[p2]++;
    }
    return true;
  }
}

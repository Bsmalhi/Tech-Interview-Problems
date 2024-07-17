class HappyNumber{
  public boolean isHappy(int n){
    Set<Integer> visited = new HashSet<>();
    while(!visited.contains(n)){
      visited.add(n);
      int output = n;
      while(n != 0){
        int a = n % 10;
        output += a * a;
        n = n / 10;
      }
      if(output == 1)
        return true;
      n = output;
    }
    return false;
  }
}

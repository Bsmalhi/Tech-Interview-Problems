class BottomUpFibonacci {
  public static int bottomUpFib(int n) {
    if(n <= 1) 
      return n;
    int a = 0, b = 1;
    for(int i = 0; i < n; i++){
      int temp = b;
      b = b + a;
      a = temp;
    }
    return b;
  }
  private static int main(String[] args){
    int n = 10;
    System.out.println("10th Fibonacci using Bottom up is: " + bottomUpFib(n));
  }
}

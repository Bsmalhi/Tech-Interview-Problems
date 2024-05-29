class PrefixSum{
  private int [] prefix;
  public PrefixSum(int[] nums){
    this.prefix = new int[nums.length];
    int total = 0;
    for(int i = 0; i < nums.length; i++){
      total += n;
      this.prefix[i] = total;
    }
  }
  // prefixSum range
  public int rangeSum(int l, int r){
    int rangeSum = this.prefixSum[r];
    int prefixSum = l > 0 ? this.prefixSum[l-1] : 0;
    return rangeSum - prefixSum;
  }
}

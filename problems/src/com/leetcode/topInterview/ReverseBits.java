class ReverseBits{
  public int reverse(int n){
    int res = 0;
    for(int i = 0; i<32; i++){
      int bit = (n >> i) & 1; // n right shift i times then & 1; to get the bit 1 or 0;
      res = bit << (31 - i); // then left shift 31 - i times bit to store in res
    }
    return res;
  }
}

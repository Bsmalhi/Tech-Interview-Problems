class MaximumSwap {
    /**
        Given int num. you can swap 2 digits at most once to get the max valued num
     */
    public int maximumSwap(int num) {
       char [] A = String.valueOf(num).toCharArray();
       int [] last = new int[10]; // as num can only contain 8 digits or 10^8 so arry of 10 is sufficient
       for(int i = 0; i < nums; i++){
         last[A[i] - '0'] = i; // store pair of num and its last index in char array
       }
       for(int i = 0; i < nums.length; i++){
         for(int d = 9; d > A[i] - '0'; i--){ // there is no point of going below A[i] as we try to swap greater num
           if(last[d] > i){
             int tmp = A[i];
             A[i] = A[last[d]];
             A[last[d]] = tmp;
             return Integer.valueOf(new String(A));
           }
         }
       }
      return num;
    }
}

    public int hammingWeight(int n) {
        int count = 0;
// because 32-bit n = 11111111111111111111111111111101 will be negative in java so we need to iterate 32 times
        int i = 32; 
        while(i-- > 0){
            if( (n & 1) == 1){
                count += 1;
            }
            // this basically does divide by 2 so now N right shit by 1 remove the most significant digit
            n = n >> 1;
        }
        return count;
    }

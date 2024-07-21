/*
For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), 
and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
*/
class RandomPickAndWeight {
    private int[] prefixSum;
    private int sum;
    Random rand;
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        for(int i = 0; i < this.prefixSum.length; i++){
            this.sum += w[i];
            this.prefixSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        double target = this.sum * Math.random();
        int i = 0;
        for(; i < prefixSum.length; i++){
            if(target < this.prefixSum[i])
                return i;
        }
        return i - 1;
    }
}

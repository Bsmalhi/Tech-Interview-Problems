class MergeTripletFromTarget {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] match = new boolean[target.length];
        for(int i = 0; i < triplets.length; i++){
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
                continue;
            for(int j = 0; j < target.length; j++){
                if(triplets[i][j] == target[j])
                    match[j] = true;
            }
                
        }
        return match[0] && match[1] && match[2];
    }
}

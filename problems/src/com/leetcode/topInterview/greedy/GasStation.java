class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
        }
        if(total < 0) return -1;
        int start = 0;
        total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }
}

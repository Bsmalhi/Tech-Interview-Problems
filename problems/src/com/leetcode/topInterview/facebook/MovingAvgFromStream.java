class MovingAvgFromStream {
    /**
        Given a stream of integers and window size, calculate the moving average of all int in the sliding window
     */
    private int size;
    private Queue<Integer> stream;
    private int sum;
    public MovingAverage(int size) {
        this.size = size;
        this.stream = new LinkedList<>();
        this.sum = 0;
    }
    
    public double next(int val) {
        this.stream.add(val);
        sum += val;
        double avg = 0;
        while(stream.size() > size){
            sum -= stream.poll();
        }
        return (double) sum / stream.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

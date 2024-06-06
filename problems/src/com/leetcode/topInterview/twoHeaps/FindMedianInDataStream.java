class FindMedianInDataStream{
    Queue<Integer> smallMaxHeap;
    Queue<Integer> largeMinHeap;
    public MedianFinder() {
          this.smallMaxHeap = new PriorityQueue((a,b) -> b - a);
          this.largeMinHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        smallMaxHeap.offer(num);
      if(smallMaxHeap.size() - largeMinHeap.size() > 1 || !largeMinHeap.isEmpty() && smallMaxHeap.peek() > largeMinHeap.peek()){
        largeMinHeap.offer(smallMaxHeap.poll());
      }
      if(largeMinHeap.size() - smallMaxHeap.size() > 1)
        smallMaxHeap.offer(largeMinHeap.poll());
    }
    
    public double findMedian() {
        if(smallMaxHeap.size() == largeMinHeap.size())
          return (double) (smallMaxHeap.peek() + largeMinHeap.peek())/2;
      if(smallMaxHeap.size() - largeMinHeap.size() > 1)
        return (double) smallMaxHeap.peek();
      else 
        return (double) largeMinHeap.peek();
    }
}

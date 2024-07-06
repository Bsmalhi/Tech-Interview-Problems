class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int n: stones)
            maxHeap.offer(n);
        
        while(maxHeap.size() > 1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if(a != b){
                maxHeap.offer(Math.abs(b - a));
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}

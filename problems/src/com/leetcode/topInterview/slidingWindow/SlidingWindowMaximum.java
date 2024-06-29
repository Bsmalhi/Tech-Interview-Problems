class SlidingWindowMaximum{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] maxList = new int[nums.length - k + 1]; // size math is length - window size k + 1
        int i = 0, j = 0;
        Deque<Integer> deque = new LinkedList<>(); // monotonically decreasing queue
        for(i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) // this helps in keeping window size equal to k if not poll from deque
                deque.pollFirst();
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) // curr num at i > num at deque.peekLast then pop
                deque.pollLast();
            deque.offer(i);
            if(i >= k - 1) // if i is equal to greater than window size then add the element in maxList
                maxList[j++] = nums[deque.peekFirst()];
        }
        return maxList;
    }
}

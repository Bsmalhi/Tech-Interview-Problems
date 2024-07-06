class DesignTwitter {
    Map<Integer, List<int[]>> tweetMap = null;
    Map<Integer, Set<Integer>> followerMap = null; 
    int count;
    public Twitter() {
        this.count = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<int[]>());
        tweetMap.get(userId).add(new int[]{count, tweetId});
        this.count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // maxHeap
        this.followerMap.putIfAbsent(userId, new HashSet<Integer>());
        followerMap.get(userId).add(userId); // user see its own tweet as well

        this.followerMap.get(userId).forEach((followeeId) -> {
            if(tweetMap.containsKey(followeeId)){
                int i = tweetMap.get(followeeId).size() - 1;
                int [] tweet = tweetMap.get(followeeId).get(i);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, --i}); // count, tweetId, followeeID, index
            }
        });
        while(!maxHeap.isEmpty() && result.size() < 10){
            int[] data = maxHeap.poll();
            result.add(data[1]);
            if(data[3] >= 0){
                int [] tweet = tweetMap.get(data[2]).get(data[3]);
                maxHeap.offer(new int[]{tweet[0], tweet[1], data[2], --data[3]});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<Integer>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.computeIfAbsent(followerId, 
            k -> new HashSet<>());
        if (set.contains(followeeId)) 
            set.remove(followeeId);
    }
}

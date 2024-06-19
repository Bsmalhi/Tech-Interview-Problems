class LastStoneWeightII {
    // arr of stones ith is weight of stone[i]
    // choose 2 stones and smash together
    // if x == y both detroyed sum += 0
    // if x != y sum = math.abs(x - y)
    // at most only one stone left return smallest possible weight of left stone or return 0 if no stones
    public int lastStoneWeightII(int[] stones) {
        Map<String, Integer> cache = new HashMap<>();
        int totalSum = Arrays.stream(stones).sum();
        int target = (totalSum + 1) / 2;  // Equivalent to Math.ceil(totalSum / 2.0)
        return dfs(0, stones, 0, target, totalSum, cache);
    }

    private int dfs(int i, int[] stones, int total, int target, int totalSum, Map<String, Integer> cache) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (totalSum - total));
        }
        String key = i + "-" + total;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        // Exclude stone
        int exclude = dfs(i + 1, stones, total, target, totalSum, cache);
        // Include stone
        int include = dfs(i + 1, stones, total + stones[i], target, totalSum, cache);
        int result = Math.min(include, exclude);
        cache.put(key, result);
        return result;
    }
}

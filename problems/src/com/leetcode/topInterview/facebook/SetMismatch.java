class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        // update count of each element
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // check map entries
        for(int i = 1; i <= nums.length; i++){
            if(map.containsKey(i)){
                if(map.get(i) == 2)
                    result[0] = i; 
            }else
                result[1] = i;
        }
        return result;
    }
}

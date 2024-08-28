class ProductOfTwoRunLenEncodedArray {
    /**
    nums = [1,1,1,2,2,2,2,2] is represented by the run-length encoded array encoded = [[1,3],[2,5]]. 
    Another way to read this is "three 1's followed by five 2's".
    You are given two run-length encoded arrays encoded1 and encoded2 representing full arrays nums1 and nums2 respectively. 
    Both nums1 and nums2 have the same length
    Return the product of encoded1 and encoded2
    Merge Segments:
    If the last segment in the result list has the same product value, we extend its count by minCount. 
    Otherwise, a new segment is added.
     */
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < encoded1.length){
            int product = encoded1[p1][0] * encoded2[p2][0];
            int minLen = Math.min(encoded1[p1][1], encoded2[p2][1]);

            // meaning the last added segment has the same product val 
            // then we just increment the len of count segment
            if(res.size() > 0 && res.get(res.size() - 1).get(0) == product){
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + minLen);
            } else {
                res.add(Arrays.asList(product, minLen));
            }
            //deduct minLen as we already built segment with product and minlength from encoded1 & encoded2 RLEs 
            encoded1[p1][1] -= minLen;
            encoded2[p2][1] -= minLen;
            // check if len is 0 then increment pointers to next segment
            if(encoded1[p1][1] == 0) p1++;
            if(encoded2[p2][1] == 0) p2++;
        }

        return res;
    }
}

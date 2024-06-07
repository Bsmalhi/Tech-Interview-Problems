class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combine = new ArrayList<>();
        helperCombine(n, k, 1, combine, new ArrayList<Integer>());
        return combine;
    }
    public void helperCombine(int n, int k, int i, List<List<Integer>> combine, List<Integer> list){
        if(list.size() == k){
            combine.add(new ArrayList<>(list));
            return;
        } 
        if(i > n){
            return;
        } else {
            list.add(i);
            helperCombine(n, k, i + 1, combine, list);
            list.remove(list.size() - 1);
            helperCombine(n, k, i + 1, combine, list);
        }
    }
}

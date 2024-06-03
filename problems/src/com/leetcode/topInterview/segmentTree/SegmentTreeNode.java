class SegmentTreeNode{ // logn update and queryRange sum operations benefit
  class Node{
    int sum = 0;
    int l = 0;
    int r = 0;
    Node left;
    Node right;
    public Node(int total, int l, int r){
      this.sum = total;
      this.l = l;
      this.r = r;
    }
  }
    Node root;
    public SegmentTreeNode(int[] nums){
      this.root = build(nums, 0, nums.length -1);
    }
    public void build(int[] nums, int l, int r){
      if(l == r) // edge case is if both l == r then that is our node this Segment tree is built from bottom up
        return new Node(nums[l], l, r);
      Node root = new Node(0, l, r);
      int mid = (l+r)/2;
      root.left = build(nums, l, mid);
      root.right = build(nums, mid+1, r);
      root.sum = root.left.sum + root.right.sum;
    }
    public void update(int index, int val){ // this function update the index of the 
      updateHelper(root, index, val);
    }
    public void updateHelper(Node root, int index, int val){
      if(root.l == root.r){
        root.sum = val;
        return;
      }
      int mid = (l + r)/2;
      if(index < mid){
        updateHelper(root.left, index, val);
      } else {
        updateHelper(root.right, index, val);
      }
      root.sum = root.left.sum + root.right.sum;
    }
  public int rangeSum(int l, int r){
    return rangeSum(root, l, r);
  }
  public int rangeSum(Node root, int l, int r){
    if(root.l == l && root.r == l)
      return root.sum;
    int mid = (l+r)/2;
    if(l > mid){
      return rangeSum(root.right, l, r); // both l & r are present on right side
    } else if(r <= mid) {
      return rangeSum(root.left, l, r); // both l & r are present on left side
    }
    // if l is on left side of mid and r is on right side of mid
    return rangeSum(root.left, l, mid) + rangeSum(root.right, mid+1, r);
  }
}

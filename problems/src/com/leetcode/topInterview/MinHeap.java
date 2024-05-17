/*
Formula for finding the left, right and parent in Heap array is
leftChild = 2 * i -> which is even value
rightChild = 2 * i + 1 -> which is always odd
parent = i/2;
*/

public class MinHeap {
  List<Integer> heap = null;
  public MinHeap(){
    this.heap = new ArrayList<>();
    this.heap.add(0); // 0th position init
  }
  public void push(int num){
    this.heap.add(num);
    int i = heap.size()-1;
    // percolate up
    while( i > 1 && heap.get(i) < heap.get(i/2)){ // this checks the parent value > i th val or not
      int temp = heap.get(i/2);
      heap.set(i/2, heap.get(i));
      heap.set(i, temp);
      i = i/2; // update i to be parent index
    }
  }
  public int pop(){
    if(heap.size() == 1)
      return null;
    if(heap.size() == 2)
      return heap.remove(1);
    int res = heap.get(1); // min heap pops the top element
    heap.set(1, heap.remove(heap.size() - 1); // remove last val and put on top 
    //percolate down as newly added val might not be correct
    while(2 * i < heap.size()){
      // if rightChild is smaller than leftChild and parent at i index then swap
      if((2 * i + 1) < heap.size() && heap.get(2 * i + 1) < heap.get(2 * i) && heap.get(2 * i + 1) < heap.get(i)){
        int temp = heap.get(2 * i + 1);
        heap.set(2 * i + 1, heap.get(i));
        heap.set(i , tmp);
        i = 2 * i + 1;
      } else if(heap.get(i) > heap.get(2 * i)){ // if left smaller than i then swap
        int temp = heap.get(i);
        heap.set(i, heap.get(2 * i));
        heap.set(2 * i, i);
        i = 2 * i;
      } else { break};
    }
    return res;
  }
  public int top() {
        if (heap.size() > 1) {
            return heap.get(1);
        }
        // Normally we would throw an exception if heap is empty.
        return -1;
  }
  // heapify converts list into heap
  public void heapify(ArrayList<Integer> arr) {
        // 0-th position is moved to the end
        arr.add(arr.get(0));

        heap = arr;
        int cur = (heap.size() - 1) / 2;
        while (cur > 0) {
            // Percolate Down
            int i = cur;
            while (2 * i < heap.size()) {
                if (2 * i + 1 < heap.size() &&
                heap.get(2 * i + 1) < heap.get(2 * i) &&
                heap.get(i) > heap.get(2 * i + 1)) {
                    // Swap right child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i + 1));
                    heap.set(2 * i + 1, tmp);
                    i = 2 * i + 1;
                } else if (heap.get(i) > heap.get(2 * i)) {
                    // Swap left child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i));
                    heap.set(2 * i, tmp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur--;
        }
        return;
    }
}
















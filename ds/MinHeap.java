package ds;

public class MinHeap {
  int[] heapArray;
  int currSize = 0;

  // utility methods
  int getLastItemIndex() {
    return currSize == 0 ? 0 : currSize  - 1;
  }

  int getParent(int index) {
    return heapArray[getParentIndex(index)];
  }

  int getParentIndex(int index) {
    return (index - 1)/2;
  }

  void swapAtIndices(int index1, int index2) {
    int temp = heapArray[index1];
    heapArray[index1] = heapArray[index2];
    heapArray[index2] = temp;
  }

  // constructor
  public MinHeap(int initialCapacity) {
    heapArray = new int[initialCapacity];
  }

  public void insert(int value) {
    heapArray[currSize] = value;
    currSize++;

    heapifyUp();
  }

  private void heapifyUp() {
    int index = getLastItemIndex();

    while(index != 0 && heapArray[index] < getParent(index)) {
      swapAtIndices(index, getParentIndex(index));
      index = getParentIndex(index);
    }
  }

  public void prettyPrint() {
    for(int i = 0; i < currSize; i++) {
      System.out.print(" " + heapArray[i] + " ");
    }
  }

  public static void main(String[] args) {
      MinHeap heap = new MinHeap(10);
      heap.insert(5);
      heap.insert(1);
      heap.insert(3);
      heap.insert(2);
      heap.insert(0);

      heap.prettyPrint();
  }
}

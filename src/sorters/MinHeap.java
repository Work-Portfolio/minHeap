package sorters;

/**
 * This class stores and manages a MinHeap array
 * Created by zachrooney on 3/15/17.
 */
public class MinHeap {
    private HeapTuple[] mArray;
    private int mSize;
    private int mCapacity;

    // public  methods -------------------------------------------

    /**
     * Constructor initializes variables. Sets mArray size to HeapTuple[] length + 1
     * @param emptyHeap
     */
    public MinHeap(HeapTuple[] emptyHeap) {
        mSize = 0;
        mCapacity = emptyHeap.length + 1;
        mArray = new HeapTuple[mCapacity];
    }

    /**
     * Returns boolean indidcating if minheap is empty
     * @return
     */
    public boolean isEmpty() {
        return mSize == 0;
    }

    /**
     * Returns boolean indicating if minheap is full
     * @return
     */
    public boolean isFull() {
        return mSize == mCapacity - 1;
    }

    /**
     * Inserts a new HeapTuple object into the next available spot then percolates up
     * @param x
     */
    public void insert(HeapTuple x) {
        if (this.isFull()) {
            System.out.println("Error: MinHeap insert() called on full heap");
            return;
        }

        int hole;

        // percolate up
        hole = ++mSize;
        for (; hole > 1 && x.compareTo(mArray[hole / 2]) < 0; hole /= 2) {
            mArray[hole] = mArray[hole / 2];
        }
        mArray[hole] = x;
    }

    /**
     * Removes and returns the root of the minHeap. Takes the last child and percolates it down from the root.
     * @return
     */
    public HeapTuple removeRoot() {
        if (this.isEmpty()) {
            System.out.println("Error: MinHeap remove() called on empty heap");
            return null;
        }

        HeapTuple minObject;
        minObject = mArray[1];
        mArray[1] = mArray[mSize--];
        percolateDown(1);

        return minObject;
    }

    /**
     *  Removes and returns the last item in the minHeap array
     * @return
     */

    public HeapTuple remove() {
        return mArray[mSize--];
    }

    /**
     *  Returns the size of the minHeap array
     * @return
     */
    public int size() {
        return mSize;
    }

    /**
     *  Returns an int representation of the last value held in the minHeap array
     * @return
     */
    public int getLast() {
        return mArray[mSize].getData();
    }

    // private helper methods ------------------------------------

    /**
     *  Order the minheap array into ascending order
     */
    private void orderHeap() {
        int k;

        for (k = mSize / 2; k > 0; k--)
            percolateDown(k);
    }

    /**
     *  Starts at the int hole position given in the minheap array. Moves the hole down util the children are greater than the value given then
     *  inserts the new value.
     * @param hole
     */
    private void percolateDown(int hole) {
        int child;
        HeapTuple tmp;

        for (tmp = mArray[hole]; 2 * hole <= mSize; hole = child) {
            child = 2 * hole;
            // if 2 children, get the lesser of the two
            if (child < mSize
                    && mArray[child + 1].compareTo(mArray[child]) < 0) {
                child++;
            }
            if (mArray[child].compareTo(tmp) < 0)
            { mArray[hole] = mArray[child];}
            else
                break;
        }
        mArray[hole] = tmp;
    }

}

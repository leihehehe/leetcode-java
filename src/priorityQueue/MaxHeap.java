package priorityQueue;

public class MaxHeap implements Queue {
    private int[] data;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        //start with index 1
        data = new int[capacity+1];
        this.capacity = capacity;
        //current size is 0
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void offer(int x) {
        if(size()+1>capacity){
            throw new IllegalArgumentException("Heap is full");
        }
        //put x at the last location
        data[size()+1] = x;
        this.size++;
        //move data[size] up
        siftUp(size);
    }

    //as long as the parent value is smaller than the current value, swap the current node and the parent node.
    public void siftUp(int k){
        while(k>1 && data[k/2]<data[k]){
            swap(data,k/2,k);
            k=k/2;
        }
    }

    @Override
    public int poll() {
        if(size()==0){
            throw new IllegalArgumentException("堆为空。");
        }
        int ret = data[1];
        data[1] = data[size];
        size--;
        siftDown(1);
        return ret;
    }

    public void siftDown(int k){
        //left child exists
        while(2*k<=size){
            int j = 2*k;
            if(j+1<=2*k && data[j+1]>data[j]){
                j++;
            }
            if(data[j]<=data[k]) break;
            swap(data,k,j);
            k=j;
        }
    }

    /**
     * Get the top node
     * @return
     */
    @Override
    public int peek() {
        if(isEmpty()) throw new IllegalArgumentException("Heap is empty");
        return data[1];
    }

    public void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * Replace
     */
    public void replace(int item){
        if(isEmpty()) throw new IllegalArgumentException("Heap is empty");
        data[1] = item;
        siftDown(1);
    }
}

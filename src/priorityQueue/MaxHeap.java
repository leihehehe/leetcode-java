package priorityQueue;

public class MaxHeap implements Queue {
    public int[] data;
    //how many elements this heap could store
    public int capacity;
    //actual nums of the elements
    public int size;
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void offer(int x) {
        if(size+1>capacity){
            throw new IllegalArgumentException("heap is full");
        }
        data[size+1]=x;
        size ++;
        siftUp(size);
    }
    public void siftUp(int k){
        //date[k/2] is the parent node
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }
    public void swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }

    @Override
    public int poll() {
        if(size==0){
            throw new IllegalArgumentException("empty heap");
        }
        int ret = data[1];
        //move the last element to the first
        data[1]=data[size];
        size--;
        siftDown(1);
        return ret;
    }

    private void siftDown(int k){
        int temp = data[k];
        //as long as it has children
        while (2 * k <= size) {
            int j = 2 * k;
            // if it has child on the right-hand side, and right > left
            if (j + 1 <= size && data[j + 1] > data[j]) {
                j++;
            }
            if (temp >= data[j]) {
                break;
            }
            //swap
            data[k] = data[j];
            k = j;
        }
        data[k] = temp;
    }

    @Override
    public int peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("empty heap");
        }
        //index 0 has no data stored
        return data[1];
    }
    public void replace(int item) {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty heap");
        }
        // 注意：堆顶元素替换，size 不变
        data[1] = item;
        siftDown(1);
    }

    public MaxHeap(int capacity){
        data = new int[capacity+1];
        this.capacity = capacity;
        size=0;
    }
}

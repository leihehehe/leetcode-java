package priorityQueue;

/**
 * Leetcode 912
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class HeapSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        //sort -> max heap
        heapify(nums,len);
        for(int i =len-1 ; i>=1;){
            swap(nums,0,i);
            i--;
            siftDown(nums,0,i);
        }
        return nums;
    }

    public void heapify(int[] nums,int len){
        for(int i = (len-1)/2; i >=0; i--){
            // from the first none-leaf node, sift down to make the nodes below sorted.
            siftDown(nums,i,len-1);
        }
    }

    public void siftDown(int[] nums, int k, int end){
        // k -> current location, end-> all the nodes after end has already been sorted.
        while(2*k+1<=end){
            //left < end
            int  j = 2*k+1;
            if(j+1 <= end && nums[j+1]>nums[j]){
                //right child node <= node and left child node > right node
                j++;//get the right child node - in order to get the smallest node
            }
            if(nums[j]>nums[k]){
                swap(nums,j,k);
            }else{
                break;
            }
            k=j;//update the current node location k = j
        }

    }
    public void swap(int[] nums,int index1, int index2){
        int temp = nums[index1];
        nums[index1]=nums[index2];
        nums[index2]= temp;
    }
}

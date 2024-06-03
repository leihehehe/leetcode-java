package bitOperation;

import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class SortByBitsSolution1 {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }
}
class SortByBitsSolution2 {
    public int[] sortByBits(int[] arr) {
        int[] res = new int[arr.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        for(int i = 0;i<arr.length;i++){
            int e = arr[i];
            pq.offer(new int[]{Integer.bitCount(e),e});
        }
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll()[1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

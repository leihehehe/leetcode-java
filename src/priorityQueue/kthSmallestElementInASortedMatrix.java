package priorityQueue;

import java.util.PriorityQueue;

/**
 * Leetcode 378
 */
public class kthSmallestElementInASortedMatrix {
    /**
     * Time complexity: O(klogn)
     * Space complexity: O(n)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(n,(a, b)->{return a[0]-b[0];});
        for(int row =0;row<matrix.length;row++){
            pq.add(new int[]{matrix[row][0],row,0});
        }
        int res = -1;
        while(!pq.isEmpty() && k>0){
            int[] cur = pq.poll();
            res = cur[0];
            k--;
            int row = cur[1], col = cur[2];
            if(col+1<matrix[row].length){
                pq.add(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return res;
    }
}

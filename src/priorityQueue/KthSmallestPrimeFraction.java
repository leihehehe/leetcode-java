package priorityQueue;

import java.util.PriorityQueue;

/**
 * Leetcode 786: K-th Smallest Prime Fraction
 */
public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        //[1,2,3,5]
        //1/3,1/5,2/5,2/3,3/5
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Double.compare(a[0]*1.0/a[1],b[0]*1.0/b[1]));
        for(int i = 1;i<arr.length;i++){
            pq.add(new int[]{arr[0],arr[i],0});
        }
        while(k>=0&&!pq.isEmpty()){
            int[] cur = pq.poll();
            k--;
            if(k==0) return new int[]{cur[0],cur[1]};
            int nextIndex = cur[2]+1;
            pq.add(new int[]{arr[nextIndex],cur[1],nextIndex});
        }
        return new int[]{0,0};
    }
}

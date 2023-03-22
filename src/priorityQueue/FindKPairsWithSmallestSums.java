package priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 373
 */
public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //[1,7,11] [2,4,6], k = 3
        //[1,2],[1,4],[1,6],[7,2],[7,4],[7,6],[11,2],[11,4],[11,6]
        //sort these pairs based on their sums
        //int[]{nums1[i],nums2[i],i}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return (a[0]+a[1])-(b[0]+b[1]);
        });

        //priority queue initialization
        for(int i = 0;i<nums1.length;i++){
            pq.add(new int[]{nums1[i],nums2[0],0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!pq.isEmpty()&&k>0){
            int[] cur = pq.poll();
            List<Integer> curArr = new ArrayList<>();
            k--;
            curArr.add(cur[0]);
            curArr.add(cur[1]);
            res.add(curArr);
            //put next node
            int nextIndex = cur[2]+1;
            if(nextIndex<nums2.length) pq.add(new int[]{cur[0],nums2[nextIndex],nextIndex});
        }
        return res;
    }
}

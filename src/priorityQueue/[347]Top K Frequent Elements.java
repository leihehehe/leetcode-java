package priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = minHeap.poll()[0];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

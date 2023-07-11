package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    /**
     * TreeMap
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            map.put(toAdd,map.getOrDefault(toAdd,0)+1);
            //缩小窗口
            while(map.lastKey() - map.firstKey() > limit){
                int toRemove = nums[l];
                l++;
                map.put(toRemove, map.get(toRemove) - 1);
                if(map.get(toRemove)==0){
                    map.remove(toRemove);
                }
            }
            res = Math.max(res, r-l);
        }
        return res;
    }

    /**
     * 两个单调队列来记录最大值和最小值
     * @param nums
     * @param limit
     * @return
     */
    public int longestSubarrayDeque(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int n = nums.length;
        int l = 0, r= 0;
        int ans = 0;
        while(r<n){
            int toAdd = nums[r];
            r++;
            //维护最大值队列
            while(!maxQueue.isEmpty() && maxQueue.peekLast()<toAdd){
                maxQueue.pollLast();
            }
            //维护最小值队列
            while(!minQueue.isEmpty() && minQueue.peekLast()>toAdd){
                minQueue.pollLast();
            }
            maxQueue.addLast(toAdd);
            minQueue.addLast(toAdd);
            //大于limit就要缩小
            while(!maxQueue.isEmpty() && !minQueue.isEmpty() &&maxQueue.peekFirst() - minQueue.peekFirst()>limit){
                int toRemove = nums[l];
                l++;
                if(toRemove == maxQueue.peekFirst()){
                    maxQueue.pollFirst();
                }
                if(toRemove == minQueue.peekFirst()){
                    minQueue.pollFirst();
                }
            }
            ans = Math.max(ans,r-l);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

package weeklyContest.slidingWindow;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 328
 */
class CountGood {
    public long countGood(int[] nums, int k) {
        int l = 0, r = 0;
        //用hashmap
        Map<Integer,Integer> map = new HashMap<>();
        long count = 0;
        long res = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            map.put(toAdd, map.getOrDefault(toAdd, 0)+1);
            if(map.get(toAdd)>1){
                count+=map.get(toAdd)-1;
            }
            while(count==k){
                res+=nums.length-r+1;
                int toRemove = nums[l];
                l++;
                if(map.get(toRemove)>1){
                    count-=map.get(toRemove)-1;
                }
                map.put(toRemove, map.get(toRemove)-1);

            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

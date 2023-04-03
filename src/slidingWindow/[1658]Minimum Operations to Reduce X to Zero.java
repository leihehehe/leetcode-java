package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumOperationsToReduceXToZero {
    /**
     * Sliding Window
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int arraySum = 0;
        for(int num:nums) arraySum+=num;
        int target = arraySum-x;
        int l =0, r=0;
        int windowSum = 0, res = Integer.MIN_VALUE;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            windowSum+=toAdd;
            while(windowSum>target&&l<r){
                int toRemove = nums[l];
                l++;
                windowSum-=toRemove;
            }
            if(windowSum==target) res = Math.max(res,r-l);
        }
        return res==Integer.MIN_VALUE?-1:n-res;
    }

    /**
     * Prefix sum
     * @param nums
     * @param x
     * @return
     */
    public int minOperationsMethod2(int[] nums, int x) {
            //minimum number of operations -> minimum length of removed numbers -> maximum length of sum(array)-x; target = sum(nums)-x
            int n = nums.length;
            int arraySum = 0;
            for(int num:nums) arraySum+=num;
            int target = arraySum-x;
            if(target==0) return n;
            int[] preSum = new int[n+1];
            //map<preSum,index>
            Map<Integer,Integer> map = new HashMap<>();

            int res = Integer.MIN_VALUE;
            map.put(0,0);
            for(int i =1;i<n+1;i++){
                preSum[i] = preSum[i-1]+nums[i-1];
                //preSum[i]-preSum[j] = target
                //preSum[j] = preSum[i]-target;
                int need = preSum[i]-target;
                if(map.containsKey(need)){
                    int index = map.get(need);
                    res = Math.max(i-index,res);
                }
                if(!map.containsKey(preSum[i])) map.put(preSum[i],i);
            }

            return res==Integer.MIN_VALUE?-1:n-res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

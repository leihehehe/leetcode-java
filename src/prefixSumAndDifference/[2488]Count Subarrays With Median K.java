package prefixSumAndDifference;

import java.util.HashMap;

class CountSubarraysSolution {
    public int countSubarrays(int[] nums, int k) {
        //k=4
        //[3,2,1,4,5]
        //[1,1,1,4,-1]
        //[1,2,3,7,6]
        //小于等于k的数为大于k的数+1或者相等
        //小于等于k的数为1，大于k的数为-1，求区间和=1或者=0
        //0 or -1
        int n = nums.length;
        int sum = 0, res = 0;
        //preSum -> count
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        boolean foundK = false;
        for(int i = 0;i<n;i++){
            if(nums[i]<k) sum+=1;
            else if(nums[i]>k) sum+=-1;
            if(nums[i]==k) foundK = true;
            if(foundK){
                int target1 = sum+1;
                int target2 = sum;
                res+=map.getOrDefault(target1,0)+map.getOrDefault(target2,0);
            }else{
                map.put(sum,map.getOrDefault(sum, 0)+1);
            }
        }
        return res;
    }
}
package weeklyContest.binarySearch;

import java.util.Arrays;

/**
 * Medium
 * Weekly Contest 332
 */
//leetcode submit region begin(Prohibit modification and deletion)
class CountTheNumberOfFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        //0,1,4,4,5,7
        long res = 0;
        for(int i = 0;i<nums.length;i++){
            int targetLower = lower - nums[i];
            int targetUpper = upper - nums[i];
            //[targetLower,targetUpper]
            int lowPos = searchLower(nums, i+1, nums.length-1, targetLower);
            int upPos = searchUpper(nums, i+1, nums.length-1, targetUpper);
            if(lowPos!=-1 && upPos!=-1){
                res+=upPos-lowPos+1;
            }
        }
        return res;
    }
    public int searchLower(int[] nums, int l, int r, int targetLower){
        if(l>r){
            return -1;
        }
        //[l,r]
        //第一个大于等于targetLower的数
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=targetLower){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(nums[l]>=targetLower) return l;
        return -1;
    }
    public int searchUpper(int[] nums,  int l, int r, int targetUpper){
        if(l>r){
            return -1;
        }
        //[l,r]
        //第一个小于等于targetUpper的数
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(nums[mid]<=targetUpper){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        if(nums[l]<=targetUpper) return l;
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

package others;

class WaysToSplitArrayIntoGoodSubarrays {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = 1000000007;
        long prev = -1;
        long res = 1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                if(prev!=-1)
                    res= res * (i-prev)%MOD;
                prev = i;
            }
        }
        return prev==-1? 0:(int)res;
    }
}

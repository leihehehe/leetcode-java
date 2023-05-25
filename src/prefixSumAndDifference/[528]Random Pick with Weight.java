package prefixSumAndDifference;

import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class RandomPickWithWeight {
    int[] preSum;
    Random random = new Random();
    public RandomPickWithWeight(int[] w) {
        preSum = new int[w.length+1];
        preSum[0]=0;
        for(int i =1;i<=w.length;i++){
            preSum[i] = preSum[i-1]+w[i-1];
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(1,preSum[preSum.length-1]+1);
        return search(preSum,target)-1;
    }
    public int search(int[] nums, int target){
        if(nums.length==0) return -1;
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                r = mid;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

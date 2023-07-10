package prefixSumAndDifference;

/**
 * Leetcode 238
 */
class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i = 1;i<nums.length;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 1;
        for(int i = nums.length-2;i>=0;i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        int[] ans = new int[nums.length];
        for(int i =0;i<ans.length;i++){
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }

    /**
     * Space Complexity O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelfMethod2(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        //前缀
        for(int i = 1;i<nums.length;i++){
            ans[i] = ans[i-1]*nums[i-1];
        }
        int suffix = 1;
        for(int i = nums.length-2;i>=0;i--){
            suffix = suffix * nums[i+1];
            ans[i] = ans[i] * suffix;
        }
        return ans;
    }
}

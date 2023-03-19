package prefixSumAndDifference;

/**
 * Leetcode 238
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length+1];
        prefix[0] = 1;
        for(int i = 1;i<nums.length+1;i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        int[] suffix = new int[nums.length+1];
        suffix[nums.length]=1;
        for(int i = nums.length-1;i>=0;i--){
            suffix[i] = suffix[i+1]*nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            nums[i] = prefix[i]*suffix[i+1];
        }
        return nums;
        //prefix = [1,2,6,24]
        //suffix = [24,24,12,4]
    }
}

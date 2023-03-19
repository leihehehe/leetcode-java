package prefixSumAndDifference;

/**
 * Leetcode 724
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length+1];
        preSum[0]=0;
        for(int i =1;i<preSum.length;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        for(int i =1;i<preSum.length;i++){
            //nums[i-1]'s left and right
            //left = nums[0..i-2];
            //right = nums[i .. nums.length]
            int left = preSum[i-1]-preSum[0];//nums[0..i-1]
            int right = preSum[nums.length]-preSum[i];//nums[0..end]-nums[0..i-1];
            if(left==right) return i-1;
        }
        return -1;
    }
}

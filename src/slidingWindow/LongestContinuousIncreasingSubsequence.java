package slidingWindow;

/***
 * Leetcode 674
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int j =0, count = 0;
        //[0,j] -> valid
        if(nums.length<=1) return nums.length;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                j=i;
            }
            count = Math.max(count,i-j+1);
        }
        return count;
    }
}

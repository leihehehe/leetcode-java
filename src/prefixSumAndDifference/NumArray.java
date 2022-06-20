package prefixSumAndDifference;

/***
 * leetcode 303 NumArray
 * acwing 795
 */
public class NumArray {

    private int sums[];

    /***
     * This function is to initialize the sum array in terms of the nums array
     * @param nums
     */
    public NumArray(int[] nums) {
        sums= new int[nums.length+1];
        //i<=nums.length, because sums[] has one more element
        for(int i =1;i<=nums.length;i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        //since sums[i] = nums[0]+nums[1]+...+sums[i-1]
        //sum[right+1] - sums[left] = nums[0]+..+nums[left-1]+nums[left]+..+nums[right] - (nums[0]+..+nums[left-1])
        return sums[right+1]-sums[left];
    }


}

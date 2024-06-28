package prefixSumAndDifference;

/**
 * Leetcode 303
 */
class RangeSumQueryImmutable {
    int[] pre;
    public RangeSumQueryImmutable(int[] nums) {
        pre = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            pre[i+1] = pre[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return pre[right+1] - pre[left];
    }
}

package prefixSumAndDifference;

class GetSumAbsoluteDifferencesSolution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //|x-a| + |x-b| + |x-c| + |x-d| = (i+1)*x - (a+b+c+d)
        //因为是递增数列,所以括号可以打开
        //同样的，可以计算后缀和, a,b,c,d都大于x
        //|x-a| + |x-b| + |x-c| + |x-d| = |a-x| + |b-x| + |c-x| + |d-x| = a+b+c+d - (n-i-1)*x
        int total = 0;
        for(int i = 0;i<nums.length;i++){
            total+=nums[i];
        }
        int[] res = new int[nums.length];
        int prefixSum = 0, suffixSum = total;
        for(int i = 0;i<nums.length;i++){
            prefixSum+=nums[i];
            suffixSum-=nums[i];
            res[i] = (i+1)*nums[i] - prefixSum + suffixSum - (nums.length-i-1) * nums[i];
        }
        return res;
    }
}

package prefixSumAndDifference;

class IsArraySpecialSolution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] pre = new int[nums.length+1];
        boolean[] ans = new boolean[queries.length];
        pre[1] = 0;
        for(int i = 1;i<nums.length;i++){
            //和前面的进行对比
            if(nums[i]%2!=nums[i-1]%2){
                pre[i+1] = pre[i];
            }else{
                pre[i+1] = pre[i] + 1;
            }
        }
        for(int i = 0;i<queries.length;i++){
            int[] q = queries[i];
            int from = q[0], to = q[1];
            //1,2
            //1,2,3,4
            if(pre[to+1] - pre[from+1] == 0){
                ans[i] = true;
            }else{
                ans[i] = false;
            }
        }
        return ans;
    }
}

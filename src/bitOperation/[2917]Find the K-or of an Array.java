package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class FindKOrSolution {
    public int findKOr(int[] nums, int k) {
        int[] bits = new int[31];
        for(int num:nums){
            for(int i = 0;i<31;i++){
                if(bits[i]>=k) continue;
                bits[i]+=(num>>i)&1;
            }
        }
        int res = 0;
        for(int i = 0;i<31;i++){
            if(bits[i]>=k){
                res|=(1<<i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

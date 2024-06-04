package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class HasTrailingZerosSolution {
    public boolean hasTrailingZeros(int[] nums) {
        //必须有两个以上的偶数
        int count = 0;
        for(int num:nums){
            if(num%2==0) count++;
            if(count==2) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

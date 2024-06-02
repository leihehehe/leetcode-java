package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class EvenOddBit {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        for(int i = 0;n>0;i^=1, n>>=1){
            if((n&1)==1) ans[i]++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

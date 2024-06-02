package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        int lowbit = n & -n;
        return n>0 && lowbit==n && Integer.numberOfTrailingZeros(lowbit)%2==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n & -n) ==n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

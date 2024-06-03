package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int x = n^ (n>>1);
        return ((x+1) & x )==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

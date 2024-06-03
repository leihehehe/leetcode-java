package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

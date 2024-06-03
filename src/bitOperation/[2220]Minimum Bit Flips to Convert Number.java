package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MinBitFlips {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start^goal);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class GetSmallestString {
    public String getSmallestString(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            int dis = Math.min(chars[i] - 'a', 'z' - chars[i] + 1);
            if (dis > k) {
                chars[i] -= k;
                break;
            }
            chars[i] = 'a';
            k -= dis;
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package dp;

/**
 * Leetcode 10
 */
class RegularExpressionMatching {
    /**
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     * @param s
     * @param p
     * @return
     */
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            //s为空，p不为空的时候
            for (int j = 2; j <= n; j++) {
                //*是代表前面的那个数可以出现0次或多次，因为我们所对比的空字符串，所以我们自然希望它出现的是0次，那么我们只需要对比前j-2是否匹配就可以了
                if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        //如果*前的字符和i相等
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            //两种情况，要么匹配0次，要么匹配n次
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[m][n];
        }
}

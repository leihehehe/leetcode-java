package dp;

/**
 * Leetcode 343
 */
class IntegerBreak {
    /**
     * TIME: O(N^2)
     * SPACE: O(N)
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //f(x) -> maximum product
        //f(10) = 1*f(9), f(10) = 1+9 = 1*9
        //f(10) = 2*f(8), f(10) = 2+8 = 2*8
        //f(10) = 3*f(7), f(10) = 3+7 = 3*7
        //f(10) = 4*f(6), f(10) = 4+6 = 4*6
        //f(10) = 5*f(5), f(10) = 5+5 = 5*5
        //f(10) = 9*f(1), f(10) = 9+1 = 9*1
        int[] dp = new int[n+1];
        for(int i = 2;i<n+1;i++){
            for(int j = 1;j<=i-1;j++){
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}

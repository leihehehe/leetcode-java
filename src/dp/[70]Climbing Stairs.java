package dp;

/**
 * Leetcode 70
 */
class ClimbingStairs {
    /**
     * Method 1: recursive method
     */
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }
    /**
     * Method 2: memo recursive method
     */
    private int[] memo;
    public int climbStairsMethod2(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        memo = new int[n+1];
        return climbStairs(n,memo);
    }
    public int climbStairs(int n, int[] memo){
        if(n==1) return 1;
        if(n==2) return 2;
        if(memo[n]==0) memo[n] = climbStairs(n-2,memo)+climbStairs(n-1,memo);
        return memo[n];
    }

    /**
     * Method 3: dynamic programming
     */
    public int climbStairsMethod3(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i =3; i<n+1;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }


    /**
     * Method 4: Dynamic programming optimized method
     */
    public int climbStairsMethod4(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        int a = 1,b=2;
        int res=0;
        for(int i = 3;i<n+1;i++){
            res = a+b;
            a = b;
            b = res;
        }
        return res;
    }
}

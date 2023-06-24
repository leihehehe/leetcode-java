package dp;

import java.util.Arrays;

/**
 * Leetcode 509
 */
class FibonacciNumber {
    /**
     * Method 1: recursion
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n<2) return n;
        return fib(n-1)+fib(n-2);
    }

    /**
     * Method 2: memo to reduce the time complexity caused by Method 1
     * @param n
     * @return
     */
    public int fib2(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return fib(n,memo);
    }
    public int fib(int n , int[] memo){
        if(n<2) return n;
        if(memo[n]==-1) memo[n]=fib(n-1)+fib(n-2);
        return memo[n];
    }

    /**
     * Method 3: Dynamic programming
     */
    public int fib3(int n){
        if(n<2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<n+1;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

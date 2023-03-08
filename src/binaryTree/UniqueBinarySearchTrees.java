package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 96
 */
public class UniqueBinarySearchTrees {
    Map<Integer,Integer> map = new HashMap<>();

    /**
     * Method 1: recursive method
     * @param n
     * @return
     */
    int numTrees(int n) {
        if(n==0 || n==1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int res = 0;
        for(int i =1; i<=n;i++){
            //i = 5
            //1,2,3,4
            //6,7
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            res+= left*right;
        }
        map.put(n,res);
        return res;
    }

    /**
     * Method 2: dp
     * @param n
     * @return
     */
    int numTreesMethod2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<=i-1;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }

        }
        return dp[n];
    }
}

package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class CountHousePlacementsSolution {
    private static final int MODULE = (int)1e9+7;
    //dp1 -> represents the arrangements in the first row
    //dp2 -> represents the arrangements in the second row
    //dp1[i] = dp1[i-1] + dp1[i-2]
    //dp2[j] = dp2[j-1] + dp2[j-2]
    //dp1[i] * dp2[j]
    public int countHousePlacements(int n) {
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[0] = 1;
        dp2[0] = 1;
        for(int i = 2;i<=n;i++){
            dp1[i] = (dp1[i-1] + dp1[i-2])%MODULE;
            dp2[i] = (dp2[i-1]+ dp2[i-2]) %MODULE;
        }
        return (int)((long)dp1[n] *dp2[n] %MODULE);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

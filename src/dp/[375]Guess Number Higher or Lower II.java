package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class GuessNumberHigherOrLowerII {
    //在class-level初始化的话，test cases公用一个cache，会很快
    static int[][] cache = new int[201][201];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }
    /*
     * the minimum money I need to successfully guess the number within [l,r]
     */
    public int dfs(int l, int r){
        if(l>=r) return 0;
        if(cache[l][r]>0) return cache[l][r];
        int min  = Integer.MAX_VALUE;
        for(int i = l;i<=r;i++){
            //最坏情况下的成本，因为题目中说了要guaratee
            //要么猜高了，要么猜底了，选最坏情况（成本最高的）
            int cur = Math.max(dfs(l,i-1),dfs(i+1,r))+i;
            min = Math.min(cur,min);
        }
        cache[l][r] = min;
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

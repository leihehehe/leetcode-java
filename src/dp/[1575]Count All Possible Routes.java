package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class CountRoutesSolution1{
    Integer[][] cache;
    public static final int MOD = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        //直接用Integer避免需要再初始化一次
        cache = new Integer[n][fuel+1];
        return dfs(locations,finish,fuel,start);
    }

    /**
     * 计算从cur开始，到finish，有多少条路径
     */
    public int dfs(int[] locations, int finish, int fuel, int cur){
        if(fuel<0){
            return 0;
        }
        if(cache[cur][fuel]!=null) return cache[cur][fuel];
        int pathCount = 0;
        //不一定到finish就是终点了，因为如果还有fuel剩下的话，他还可以绕一圈
        if(cur==finish) pathCount=1;
        for(int i =0;i<locations.length;i++){
            if(i==cur) continue;
            int needFuel = Math.abs(locations[i] - locations[cur]);
            pathCount= (pathCount + dfs(locations,finish,fuel-needFuel,i))%MOD;
        }
        cache[cur][fuel] = pathCount;
        return pathCount;
    }
}
class CountRoutesSolution2 {
    public static final int MOD = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        //直接用Integer避免需要再初始化一次
        int[][] dp = new int[n][fuel+1];
        for (int i = 0; i <= fuel; i++) dp[finish][i] = 1;
        //这里先循环fuel的原因是dp[i][j]是依赖于dp[k][j-needFuel]的，k是[0,n)的范围，而j-needFuel是小于j的。
        //画出dp表格可以发现，需要先得到当前列j之前的所有列，对应每一行的数据。所以j对应的fuel的遍历，一定要放在外层。另外因为j-needFuel是小于j的，所以要从小到大遍历。
        for(int j = 0;j<=fuel;j++){
            for(int i =0;i<n;i++){
                for(int k = 0;k<n;k++){
                    if(k==i) continue;
                    int needFuel = Math.abs(locations[i] - locations[k]);
                    if(j>=needFuel)
                        dp[i][j] = (dp[i][j]+ dp[k][j-needFuel])%MOD;
                }
            }
        }
        return dp[start][fuel];
    }
}


//leetcode submit region end(Prohibit modification and deletion)

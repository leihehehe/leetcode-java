package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        //0不超过m个
        //1不超过n个
        //dp[k][i][j] => 前k件物品，满足0不超过i，0不超过j，最大价值(每个价值为1)？
        //不选：dp[k-1][i][j]
        //选：dp[k-1][i-nums_k_0][j-nums_k_1]
        int[][] count = new int[len+1][2];
        //统计每个字符串的1和0
        for(int i = 0;i<len;i++){
            String str = strs[i];
            for(char c: str.toCharArray()){
                if(c=='0') count[i+1][0]++;
                else count[i+1][1]++;
            }
        }

        int[][] dp = new int[m+1][n+1];
        for(int k = 1;k<=len;k++){
            for(int i =m;i>=0;i--){
                for(int j=n;j>=0;j--){
                    //背包容量不够，不选
                    if(count[k][0]>i || count[k][1]>j){
                        dp[i][j] = dp[i][j];
                    }else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-count[k][0]][j-count[k][1]]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

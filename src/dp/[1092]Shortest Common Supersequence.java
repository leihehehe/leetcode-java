package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        //首先找到最长公共子序列，然后将两个字符串独有的字符加入结果
        int m = str1.length();
        int n = str2.length();
        //dp[i][j]=》str1的前i个字符和str2的前j个字符，最长公共子序列的长度是？
        int[][] dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i =m, j = n;
        while(i>0 & j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

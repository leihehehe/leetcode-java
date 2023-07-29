package dp.digitDP;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfDigitOne {
    char[] s;
    int[][] memo;
    public int countDigitOne(int n) {
        //1,10,11,12,13
        s = String.valueOf(n).toCharArray();
        int m = s.length;
        memo = new int[m][m];
        for(int i = 0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0,true);
    }
    //这里状态包含i和count
    //填写第i位后，总共有多少个1（当前+之前，所以需要把count1给传到下一层去）
    //之所以要定义有多少个1，是因为为了记忆化的答案满足：输入相同，结果相同
    //只靠【填写到第i位】并不能确定唯一的答案，比如10_ 和 20_，都是在填写第2位，但答案实际上不一样，不能用做记忆化搜索，因此需要确定另一个状态，也就是已经存在多少个1。
    public int dfs(int i,int count, boolean isLimit){
        if(i==s.length){
            return count;
        }
        if(!isLimit && memo[i][count]!=-1){
            return memo[i][count];
        }
        int res = 0;
        int up = isLimit?s[i]-'0':9;
        //枚举
        for(int d = 0;d<=up;d++){
            res+=dfs(i+1,count+(d==1?1:0),isLimit && d==up);
        }
        if(!isLimit){
            memo[i][count] = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

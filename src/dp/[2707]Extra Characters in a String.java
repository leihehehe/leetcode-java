package dp;

import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 105
 */
class MinExtraCharSolution1 {
    HashSet<String> dic = new HashSet<>();
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        for(String str:dictionary){
            dic.add(str);
        }
        return dfs(s,s.length()-1);
    }
    public int dfs(String s, int i){
        if(i<0){
            return 0;
        }
        if(memo.containsKey(i)){
            return memo.get(i);
        }
        //不选择该字符,那么该字符就是剩下来的
        int res = dfs(s,i-1)+1;
        //选择该字符，说明该字符部分是没有剩余的，那么就需要看前面选以后剩下的部分
        for(int j  = 0;j<=i;j++){
            String substr = s.substring(j,i+1);
            if(dic.contains(substr)){
                res = Math.min(res, dfs(s,j-1));
            }
        }
        memo.put(i, res);
        return res;
    }
}
class MinExtraCharSolution2 {
    HashSet<String> dic = new HashSet<>();
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(String str:dictionary){
            dic.add(str);
        }
        for(int i = 0;i<s.length();i++){
            //不选择该字符,那么该字符就是剩下来的
            dp[i+1] = dp[i]+1;
            //选择该字符，说明该字符部分是没有剩余的，那么就需要看前面选以后剩下的部分
            for(int j = 0;j<=i;j++){
                String substr = s.substring(j,i+1);
                if(dic.contains(substr)){
                    dp[i+1] = Math.min(dp[i+1], dp[j]);
                }
            }
        }

        return dp[n];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

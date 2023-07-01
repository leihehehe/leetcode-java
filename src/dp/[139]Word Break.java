package dp;

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class WordBreak {
    /**
     * 序列dp，非完全背包。完全背包都是无序的
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i =1;i<=len;i++){
            for(String word : wordDict){
                //选或不选的问题
                //选
                int wordLen = word.length();
                if(i-wordLen>=0 && s.substring(i-wordLen,i).equals(word)){
                    dp[i] = dp[i] || dp[i-wordLen];
                    //根据dp[i]的定义=》 前i个字符是否能被拆分。一旦我们确定 dp[i] 是 true，我们就不需要再检查其他单词了
                    if(dp[i]) break;
                }

            }
        }
        return dp[len];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

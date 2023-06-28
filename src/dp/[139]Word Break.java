package dp;

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //考虑s是否能由wordDict得到
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =1;i<=s.length();i++){
            //判断单词
            for(int j = 0;j<wordDict.size();j++){
                String word = wordDict.get(j);
                int len = word.length();
                //检查i-len,i这一段是不是可以选，检查之前的是不是true
                if(i>=len && s.substring(i-len,i).equals(word)){
                    dp[i]=dp[i-len];
                    if(dp[i]) break;

                }

            }
        }
        return dp[s.length()];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

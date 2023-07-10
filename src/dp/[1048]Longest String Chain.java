package dp;

import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a, b)->a.length()-b.length());
        int n = words.length;
        //dp[i]为以words[i]结尾的最长词链，不一定是连续的
        HashMap<String,Integer> map = new HashMap<>();
        int maxLen = 1;
        for(int i = 0;i<n;i++){
            String word = words[i];
            int curLen = 1;
            for(int j = 0;j<word.length();j++){
                String target = word.substring(0,j)+word.substring(j+1,word.length());
                curLen = Math.max(curLen,map.getOrDefault(target,0)+1);
            }
            map.put(word,curLen);
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

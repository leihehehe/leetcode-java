package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestStringChainSolution1 {
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

class LongestStringChainSolution2 {
    Map<String,Integer> map = new HashMap<>();
    public int longestStrChain(String[] words) {

        for(int i = 0;i<words.length;i++){
            map.put(words[i],0);
        }
        int res = 0;
        for(int i = 0;i<words.length;i++){
            res = Math.max(res,dfs(words[i]));
        }
        return res;
    }

    //当word是chain中的最后一个单词，长度是多少？
    public int dfs(String word){
        int res = map.getOrDefault(word,0);
        if(res>0){
            return res;
        }
        for(int i = 0;i<word.length();i++){
            String newStr = word.substring(0,i)+word.substring(i+1);
            if(map.containsKey(newStr)){
                res= Math.max(res,dfs(newStr));
            }
        }
        res+=1;
        map.put(word,res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

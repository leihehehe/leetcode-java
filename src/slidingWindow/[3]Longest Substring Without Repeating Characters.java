package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int l = 0, r =0, res = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            window.put(c,window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                char toRemove = s.charAt(l);
                l++;
                window.put(toRemove,window.get(toRemove)-1);
            }
            res = Math.max(res,r-l);
        }
        return res;
    }

    /**
     * Dp solution
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringDP(String s) {
        int n = s.length();
        if(n==0) return 0;
        //dp[i]以s[i]结尾的最长无重复字符
        int[] dp = new int[n];
        dp[0] = 1;
        //最后一次出现的位置
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(s.charAt(0),0);
        int maxLen = 1;
        for(int i = 1;i<n;i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch) || i-map.get(ch)>dp[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                //计算最后一次出现的位置到现在的距离，就是最长无重复子串长度
                dp[i] = i-map.get(ch);
            }
            map.put(ch,i);
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package weeklyContest.dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Biweekly Contest 101
 */
class MaximumCostSubstring {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] dp = new int[s.length()];
        int[] map = new int[26];
        Arrays.fill(map, -1111);
        for(int i = 0;i<chars.length();i++){
            char c = chars.charAt(i);
            map[c-'a']=vals[i];
        }
        int res = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            int val = map[c-'a']==-1111?c-'a'+1:map[c-'a'];
            if(i==0){
                dp[i] = Math.max(0,val);
            }else{
                dp[i] = Math.max(dp[i-1] + val,val);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

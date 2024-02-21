package weeklyContest.greedy;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 384
 */
class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int total = 0;
        int mask = 0;
        for(String word:words){
            total+=word.length();
            for(char c:word.toCharArray()){
                mask^=1<<c-'a';
            }
        }
        total -= Integer.bitCount(mask);
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int ans = 0;
        for(String word:words){
            total-=word.length()/2*2;
            if(total<0){
                break;
            }
            ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

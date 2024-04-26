package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Biweekly Contest 106
 */
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int l = 0, r = 0;
        //[l,r)
        int res = 0;
        int count = 0;
        int n = s.length();
        while(r<n){
            char toAdd = s.charAt(r);
            if(r-1>=0 && toAdd==s.charAt(r-1)){
                count++;
            }
            r++;
            //when the number of pairs of the same digits > 1
            while(count>1){
                char toRemove = s.charAt(l);
                if(l+1<n && toRemove == s.charAt(l+1)){
                    count--;
                }
                l++;
            }
            res = Math.max(res, r-l);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

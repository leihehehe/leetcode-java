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
}
//leetcode submit region end(Prohibit modification and deletion)

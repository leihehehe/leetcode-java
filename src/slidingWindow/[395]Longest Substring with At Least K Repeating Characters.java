package slidingWindow;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for(int i = 1;i<=26;i++){
            maxLen = Math.max(maxLen,longestSubString(s,k,i));
        }
        return maxLen;
    }
    //这里的count是规定了有多少种类型的字符
    public int longestSubString(String s, int k, int count){
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int meet = 0;
        int maxLen = 0;
        while(r<n){
            char toAdd = s.charAt(r);
            r++;
            map.put(toAdd,map.getOrDefault(toAdd,0)+1);
            //一个字符已经满足条件
            if(map.get(toAdd)==k){
                meet++;
            }
            //如果说窗口内的字符种类>指定的count种类
            while(map.size()>count){
                char toRemove = s.charAt(l);
                l++;
                map.put(toRemove,map.get(toRemove)-1);
                if(map.get(toRemove)==k-1){
                    meet--;
                }
                if(map.get(toRemove)==0){
                    map.remove(toRemove);
                }
            }
            if(meet==count){
                maxLen = Math.max(r-l,maxLen);
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

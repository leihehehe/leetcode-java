package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumWindowSubstring {
    private Map<Character, Integer> window;
    private Map<Character,Integer> need;
    public String minWindow(String s, String t) {
        window = new HashMap<>();
        need = new HashMap<>();
        for(int i =0;i<t.length();i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        //loop invariant: [l,r) is a valid substring
        int l =0, r = 0;
        int valid=0;
        int start = 0, len = Integer.MAX_VALUE;
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }
            //start moving the left edge when all the requirements are met
            while(valid == need.size()){
                if(r-l<len){
                    start = l;
                    len = r-l;
                }
                char toRemove = s.charAt(l);
                l++;
                if(need.containsKey(toRemove)){
                    if(window.get(toRemove).equals(need.get(toRemove))) valid--;
                    window.put(toRemove,window.get(toRemove)-1);
                }
            }
        }
        return len!=Integer.MAX_VALUE?s.substring(start,start+len):"";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

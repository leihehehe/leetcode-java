package slidingWindow;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class PermutationInString {
    private Map<Character,Integer> window = new HashMap<>();
    private Map<Character,Integer> need = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0;i<s1.length();i++){
            char c = s1.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int l = 0, r = 0;
        int valid =0;
        while(r<s2.length()){
            char c = s2.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.getOrDefault(c,0))) valid++;
            }
            while(r-l==s1.length()){
                if(valid==need.size()) return true;
                char toRemove = s2.charAt(l);
                l++;
                if(need.containsKey(toRemove)){
                    if(window.get(toRemove).equals(need.get(toRemove))) valid--;
                    window.put(toRemove,window.get(toRemove)-1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class FindAllAnagramsInaString {
    private Map<Character,Integer> window = new HashMap<>();
    private Map<Character,Integer> need = new HashMap<>();
    public List<Integer> findAnagrams(String s, String p) {
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int l = 0, r = 0, valid = 0;
        List<Integer> res =  new ArrayList<>();
        while(r<s.length()){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }

            while(r-l>=p.length()){
                if(valid==need.size()){
                    res.add(l);
                }
                char toRemove = s.charAt(l);
                l++;
                if(need.containsKey(toRemove)){
                    if(need.get(toRemove).equals(window.get(toRemove))) valid--;
                    window.put(toRemove,window.get(toRemove)-1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

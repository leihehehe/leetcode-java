package weeklyContest.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Weekly Contest 390
 * Easy
 */
class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int unmeet= 0;
        int l = 0, r = 0;
        int max=0;
        //[l,r)
        while(r<s.length()){
            char toAdd = s.charAt(r);
            r++;
            map.put(toAdd,map.getOrDefault(toAdd,0)+1);
            if(map.get(toAdd)==3){
                unmeet++;
            }
            while(unmeet>0){
                char toRemove = s.charAt(l);
                l++;
                map.put(toRemove,map.get(toRemove)-1);
                if(map.get(toRemove)==2){
                    unmeet--;
                }
            }
            max = Math.max(r-l,max);
        }
        return max;
    }
}

package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class FindTheLongestSubstringSolution {
    public int findTheLongestSubstring(String s) {
        //aeiou -> even number
        int n = s.length();
        //mask -> index
        Map<Integer,Integer> map = new HashMap<>();
        int mask = 0;
        map.put(0,-1);
        var res = 0;
        //y - x -> even
        //a[j]是偶数-》a[i]也是偶数
        //a[j]是奇数 -> a[i]也是奇数
        //1->奇数
        //0->偶数
        //aeiou
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(c=='a')
                mask ^= (1<<4);
            if(c=='e')
                mask ^= (1<<3);
            if(c=='i')
                mask ^= (1<<2);
            if(c=='o')
                mask ^= (1<<1);
            if(c=='u')
                mask ^= 1;
            if(map.containsKey(mask)){
                res = Math.max(res,i - map.get(mask));
            }else{
                map.put(mask,i);
            }

        }
        return res;
    }
}

package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class WonderfulSubstringsSolution {
    public long wonderfulSubstrings(String word) {
        //a -> j
        //at most one letter -> freq -> odd
        //odd - odd = even
        //even - even = odd

        int mask = 0;
        Map<Integer,Long> map = new HashMap<>();
        int n = word.length();
        long res = 0;
        map.put(0,1L);
        for(int i = 0;i<n;i++){
            char c = word.charAt(i);
            mask ^= (1 << (c-'a'));
            for(int j = 0;j<10;j++){
                var target = mask ^ (1<<j);
                res+=map.getOrDefault(target, 0L);
            }
            res+=map.getOrDefault(mask, 0L);
            map.merge(mask, 1L, Long::sum);
        }
        return res;
    }
}
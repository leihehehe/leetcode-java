package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class LongestAwesomeSolution {
    public int longestAwesome(String s) {
        //freq为odd的只能有一个
        int n = s.length();
        //0101010101
        //mask -> integer
        Map<Integer,Integer> map = new HashMap<>();
        int mask = 0;
        int res = 0;
        map.put(0,-1);
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            //奇数->1, 偶数->0
            int num = c-'0';
            mask = mask ^ (1 << num);
            //情况1:一个数不同，但其他数都相同 (奇偶)
            //情况2:都相同
            for(int j = 0;j<=9;j++){
                var target = mask ^ (1 << j);
                if(map.containsKey(target)){
                    res = Math.max(res, i-map.get(target));
                }
            }
            if(map.containsKey(mask)){
                res = Math.max(res,i-map.get(mask));
            }else{
                map.put(mask,i);
            }

        }
        return res;
    }
}

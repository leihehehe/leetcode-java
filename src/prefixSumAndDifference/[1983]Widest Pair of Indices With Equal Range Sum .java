package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class WidestPairOfIndicesSolution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        //sum1[j] - sum1[i] = sum2[j] - sum2[i]
        //sum1[j] - sum2[j]  = sum1[i] - sum2[i]
        int n = nums1.length;
        int sum1=0, sum2=0;
        int res = 0;
        //diff -> index
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i = 0;i<n;i++){
            sum1+=nums1[i];
            sum2+=nums2[i];
            int tmp = sum1-sum2;
            if(map.containsKey(tmp)){
                res= Math.max(res,i - map.get(tmp));
            }

            if(!map.containsKey(tmp)){
                map.put(tmp, i);
            }
        }
        return res;
    }
}
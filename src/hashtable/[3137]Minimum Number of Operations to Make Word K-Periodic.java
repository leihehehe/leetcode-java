package hashtable;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumOperationsToMakeKPeriodicSolution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        Map<String,Integer> map = new HashMap<>();
        int j = k-1;
        int maxCount = 0;
        for(int i = 0;i<n&&j<n;i+=k,j+=k){
            String str = word.substring(i,j+1);
            map.put(str,map.getOrDefault(str, 0)+1);
            maxCount = Math.max(maxCount,map.get(str));
        }
        return n/k-maxCount;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

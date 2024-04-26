package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        Map<Integer,Integer> count = new HashMap<>();
        int[] res = new int[n/2];
        //一次遍历
        for(int i = 0,j = 0;i<n;i++){
            if(!count.containsKey(changed[i])){
                if(j==n/2) return new int[]{};
                //这里不需要添加changed[i]，因为后面不可能需要changed[i]了
                count.put(changed[i]*2, count.getOrDefault(changed[i]*2,0)+1);
                res[j++] = changed[i];
            }else{
                count.put(changed[i], count.get(changed[i])-1);
                if(count.get(changed[i])==0) count.remove(changed[i]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

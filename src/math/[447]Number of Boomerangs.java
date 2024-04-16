package math;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for(int i = 0;i<n-1;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            map.clear();
            for(int j = i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2);
                int count = map.getOrDefault(distance,0);
                //边统计边计算当前point和之前的point
                ans+=count*2;
                map.put(distance,count+1);
            }
        }
        return ans;
    }
}
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            map.clear();
            for(int j = 0;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int distance = Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2);
                int count = map.getOrDefault(distance,0);
                //边统计边计算当前point和之前的point
                ans+=count*2;
                map.put(distance,count+1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

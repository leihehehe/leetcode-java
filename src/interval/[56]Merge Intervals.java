package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i = 1;i<intervals.length;i++){
            int[] interval = intervals[i];
            //[   ]
            //      [ ]
            if(interval[0]>right){
                res.add(new int[]{left,right});
                left = interval[0];
                right = interval[1];

            }else if(interval[1]>right){
                right = interval[1];
            }
        }
        res.add(new int[]{left,right});
        return res.toArray(new int[res.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

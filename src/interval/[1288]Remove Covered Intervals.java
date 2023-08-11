package interval;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int right = intervals[0][1];
        int count = 0;
        for(int i = 1;i<intervals.length;i++){
            int[] interval = intervals[i];
            if(interval[1]<=right){
                count++;
            }
            else right = interval[1];
        }
        return intervals.length-count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

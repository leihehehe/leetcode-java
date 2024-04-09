package weeklyContest.groupedIteration;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges {
    /**
     * [0,1,2,4,5,7]
     * pointer i
     * first, find the start position of the "range"
     *      starts with index 0, if the end found, move this start pointer to the position after end pos
     * second, find the end position of the "range"
     *      if nums[curPos] - nums[curPos-1] = 1 -> i++
     * append the result into the `res`
     *      if startPos == endPos: a single string / start->end
     */

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0, n = nums.length;
        while(i<n){
            int start = i;
            i++;
            while(i<n && nums[i] - nums[i-1] == 1 ){
                i++;
            }
            i--;
            if(start == i){
                res.add(""+nums[i]);
            }else{
                res.add(nums[start]+"->"+nums[i]);
            }
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

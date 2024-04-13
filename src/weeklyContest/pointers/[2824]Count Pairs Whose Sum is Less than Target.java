package weeklyContest.pointers;

import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CountPairs {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int l = 0, r = n-1;
        int res = 0;
        while(l<r){
            if(nums.get(l)+nums.get(r)>=target){
                r--;
            }else{
                //求个数而不是求长度
                res+=r-l;
                l++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

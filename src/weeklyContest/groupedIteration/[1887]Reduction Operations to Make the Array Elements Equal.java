package weeklyContest.groupedIteration;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ReductionOperations {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序
        int n = nums.length;
        //[1,1,1,3,3,5,5]
        //分组
        int i = 0;
        int group = 0;
        int ans = 0;
        while(i<n){
            int start = i;
            while(i<n-1 && nums[i] == nums[i+1]){
                i++;
            }
            group++;
            ans+= (i-start+1)*(group-1);
            i++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package doublePointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;;
            int l = i+1, r = nums.length-1;
            int need = -nums[i];
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum==need){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1])
                        l++;
                    while(l<r && nums[r]==nums[r+1])
                        r--;
                }else if (sum>need){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

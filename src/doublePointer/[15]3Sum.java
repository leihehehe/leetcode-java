package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n-2;i++){
            int target =  -nums[i];
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]>0) break;
            if(nums[i]+nums[n-2]+nums[n-1]<0) continue;
            int l = i+1, r = n-1;
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum>target){
                    r--;
                }else if(sum==target){
                    res.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(l<r && nums[r] == nums[r+1]){
                        r--;
                    }
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

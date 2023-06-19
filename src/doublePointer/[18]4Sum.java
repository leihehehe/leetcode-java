package doublePointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0;i<nums.length-3;i++){
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j = i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int l = j+1, r = nums.length-1;
                while(l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum>target){
                        r--;
                    }else if(sum<target){
                        l++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;
                        while(l<r && nums[l]==nums[l-1])
                            l++;
                        while(l<r && nums[r]==nums[r+1])
                            r--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

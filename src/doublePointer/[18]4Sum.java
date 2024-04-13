package doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            long s1 = (long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(s1>target) break;
            long s2= (long)nums[i]+nums[n-3]+nums[n-2]+nums[n-1];
            if(s2<target) continue;
            for(int j = i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                long s3 = (long)nums[i]+nums[j]+nums[j+1]+nums[j+2];
                if(s3>target) break;
                long s4 = (long)nums[i]+nums[j]+nums[n-2]+nums[n-1];
                if(s4<target) continue;
                int l = j+1, r = n-1;
                while(l<r){
                    long sum = (long)nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        res.add(List.of((int)nums[i],(int)nums[j],nums[l],nums[r]));
                        l++;
                        while(l<r && nums[l]==nums[l-1]) l++;
                        r--;
                        while(l<r && nums[r]==nums[r+1]) r--;

                    }else if(sum>target){
                        r--;
                        while(l<r && nums[r]==nums[r+1]) r--;
                    }else if(sum<target){
                        l++;
                        while(l<r && nums[l]==nums[l-1]) l++;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

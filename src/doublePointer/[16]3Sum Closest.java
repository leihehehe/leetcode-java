package doublePointer;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int ans = nums[0]+nums[1]+nums[2];
        for(int i = 0;i<n-2;i++){
            int num1 = nums[i];
            int l = i+1, r = n-1;
            int sum1 = num1+nums[i+1]+nums[i+2];
            if(sum1>target){
                if(sum1-target<minDiff){
                    minDiff = sum1-target;
                    ans = sum1;
                }
                break;
            }

            int sum2 = num1+nums[n-1]+nums[n-2];
            if(sum2<target){
                if(target-sum2<minDiff){
                    minDiff = target-sum2;
                    ans = sum2;
                }
                continue;
            }
            while(l<r){
                int curSum = num1+nums[l]+nums[r];
                if(curSum>target){
                    r--;
                    if(curSum-target<minDiff){
                        minDiff = curSum-target;
                        ans = curSum;
                    }
                }else if(curSum==target){
                    return curSum;
                }else{
                    l++;
                    if(target-curSum<minDiff){
                        minDiff = target-curSum;
                        ans = curSum;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

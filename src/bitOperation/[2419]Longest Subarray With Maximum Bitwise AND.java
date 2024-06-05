package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestSubarraySolution {
    public int longestSubarray(int[] nums) {
        //数字只有和他自己AND才会保持不变，其他都会变小
        int n = nums.length;
        int maxCount = 1;
        int maxNum = nums[0];
        int count = 1;
        for(int i = 1;i<n;i++){
            if(nums[i]>maxNum){
                count = 1;
                maxCount = 1;
                maxNum = nums[i];
            }
            else if(nums[i]==maxNum){
                if(nums[i]==nums[i-1]){
                    count++;
                    if(count>maxCount){
                        maxCount = count;
                        maxNum = nums[i];
                    }
                    continue;
                }else{
                    count = 1;
                }
            }


        }
        return maxCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

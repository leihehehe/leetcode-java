package weeklyContest.slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 342
 */
class SlidingSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        //sliding window
        //[l,r) -> valid
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] count = new int[max-min+1];
        int p = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            count[toAdd-min]++;
            if(r-l==k){
                //iterate the count
                int rank = 0;
                for(int i = 0;i<count.length;i++){
                    rank+=count[i];
                    //找到了第x大的数字
                    if(rank>=x){
                        //该数字是否为负数
                        if(i+min < 0)
                            res[p++] = i+min;
                        else{
                            res[p++] = 0;
                        }
                        //只要找到了第x大的数字，就应该看下一个窗口了
                        break;
                    }
                }
                int toRemove = nums[l];
                l++;
                count[toRemove-min]--;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package weeklyContest.dp;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * Biweekly Contest 116
 */
class LengthOfLongestSubsequenceSolution1 {
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        memo = new int[n][target+1];
        for(int[] m:memo) Arrays.fill(m, -1);
        int res = dfs(nums, n-1, target);
        return res<0?-1:res;
    }
    //选几个数刚好凑成target

    public int dfs(List<Integer> nums, int i, int target){
        if(i<0){
            //不用选了，合适
            if(target==0){
                return 0;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if(memo[i][target]!=-1) return memo[i][target];
        //选或不选
        int res = Integer.MIN_VALUE;
        if(nums.get(i)>target){
            //不选
            res = dfs(nums, i-1, target);
        }else{
            //选或不选,选的话加上本身长度
            res = Math.max(dfs(nums, i-1, target), dfs(nums,i-1,target-nums.get(i))+1);
        }
        memo[i][target] = res;
        return res;
    }
}
class LengthOfLongestSubsequenceSolution2 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] memo = new int[n+1][target+1];
        Arrays.fill(memo[0],Integer.MIN_VALUE);
        memo[0][0] = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=target;j++){
                if(nums.get(i)>j){
                    //不选
                    memo[i+1][j] = memo[i][j];
                }else{
                    //选或不选,选的话加上本身长度
                    memo[i+1][j] = Math.max(memo[i][j],memo[i][j-nums.get(i)]+1);
                }
            }
        }

        return memo[n][target]<0?-1:memo[n][target];
    }

}
class LengthOfLongestSubsequenceSolution3 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[] memo = new int[target+1];
        Arrays.fill(memo,Integer.MIN_VALUE);
        memo[0] = 0;
        for(int i = 0;i<n;i++){
            for(int j = target;j>=0;j--){
                if(nums.get(i)<=j){
                    //选或不选,选的话加上本身长度
                    memo[j] = Math.max(memo[j],memo[j-nums.get(i)]+1);
                }
            }
        }
        return memo[target]<0?-1:memo[target];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

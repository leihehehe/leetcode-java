package prefixSumAndDifference;

import java.util.Arrays;

class AnswerQueriesSolution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        int[] prefix = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i = 0;i<queries.length;i++){
            int q = queries[i];
            //二分
            int l = 1, r = nums.length;
            while(l<r){
                int mid = (l+r+1)/2;
                //last num -> <=q
                if(prefix[mid]-prefix[0] <=q){
                    l = mid;
                }else{
                    r = mid-1;
                }
            }
            ans[i] = (prefix[l]-prefix[0]<=q)? l:0;

        }
        return ans;
    }
}

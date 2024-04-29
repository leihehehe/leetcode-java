package prefixSumAndDifference;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class AnswerQueriesSolution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] prefix = new int[n+1];
        for(int i = 0;i<n;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        //[1,2,4,5]
        //[0,1,3,7,12]
        int[] res = new int[m];
        for(int i = 0;i<m;i++){
            int query = queries[i];
            int l = 0, r = n;
            while(l<r){
                int mid = l+r>>1;
                if(prefix[mid]<=query){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
            if(prefix[l]<=query){
                res[i] = n;
            }else{
                res[i] = l-1;
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

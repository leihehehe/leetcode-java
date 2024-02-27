package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxDotProductSolution1 {
    Integer[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        memo = new Integer[n][m];
        int ans = dfs(nums1, nums2, n-1, m-1);

        return ans;
    }
    //dot point

    public int dfs(int[] nums1, int[] nums2, int i, int j){
        //当其中一个数组遍历完以后，就找不到相同长度的dot product了
        if(i<0 || j <0){
            //这里不能写成Integer.MIN_VALUE
            //因为后面有dfs(nums1,nums2,i-1,j-1)+nums1[i]*nums2[j]
            //如果nums1[i]*nums2[j]为负数，则会造成溢出
            return -1000001;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        //选当前i和j，不选i和j之前的（因为当前的两个也可以作为单独的subsequence）
        int onlyCurrent = nums1[i]*nums2[j];
        //选当前i和j，也要选i和j之前的
        int takeBoth = dfs(nums1,nums2,i-1,j-1)+nums1[i]*nums2[j];
        //不选i
        int takeJ = dfs(nums1,nums2,i-1,j);
        //不选j
        int takeI = dfs(nums1,nums2,i,j-1);

        memo[i][j] = Math.max(onlyCurrent, Math.max(Math.max(takeJ,takeI),takeBoth));
        return memo[i][j];
    }
}
class MaxDotProductSolution2 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] memo = new int[n+1][m+1];
        for(int j = 0;j<m;j++){
            memo[0][j+1] =  -1000001;
        }
        for(int i = 0;i<n;i++){
            memo[i+1][0] =  -1000001;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                //选当前i和j，不选i和j之前的（因为当前的两个也可以作为单独的subsequence）
                int onlyCurrent = nums1[i]*nums2[j];
                //选当前i和j，也要选i和j之前的
                int takeBoth = memo[i][j]+nums1[i]*nums2[j];
                //不选i
                int takeJ = memo[i][j+1];
                //不选j
                int takeI = memo[i+1][j];

                memo[i+1][j+1] = Math.max(onlyCurrent, Math.max(Math.max(takeJ,takeI),takeBoth));

            }
        }

        return memo[n][m];
    }

}

class MaxDotProductSolution3 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] memo = new int[m+1];
        for(int j = 0;j<m;j++){
            memo[j+1] =  -1000001;
        }
        for(int i = 0;i<n;i++){
            memo[0] =  -1000001;
        }

        for(int i = 0;i<n;i++){
            int prev = 0;
            for(int j = 0;j<m;j++){
                int temp = memo[j+1];
                //选当前i和j，不选i和j之前的（因为当前的两个也可以作为单独的subsequence）
                int onlyCurrent = nums1[i]*nums2[j];
                //选当前i和j，也要选i和j之前的
                int takeBoth = prev+nums1[i]*nums2[j];
                //不选i
                int takeJ = memo[j+1];
                //不选j
                int takeI = memo[j];

                memo[j+1] = Math.max(onlyCurrent, Math.max(Math.max(takeJ,takeI),takeBoth));
                prev = temp;
            }
        }

        return memo[m];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

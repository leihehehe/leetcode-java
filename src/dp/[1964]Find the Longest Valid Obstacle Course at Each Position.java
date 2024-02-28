package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestObstacleCourseAtEachPosition1 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1;i<n;i++){
            int max=0;
            for(int j = 0;j<i;j++){
                if(obstacles[j]<=obstacles[i]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
        }
        return dp;
    }

}
class LongestObstacleCourseAtEachPosition2 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] arr = new int[n];
        //greedy
        arr[0] = obstacles[0];
        int j = 0;
        int[] ans = new int[n];
        ans[0] = 1;
        //[0,j] -> valid
        for(int i = 1;i<n;i++){
            if(obstacles[i]>=arr[j]){
                arr[++j] = obstacles[i];
                ans[i] = j+1;
            }else{
                int l = 0, r = j;
                while(l<r){
                    int mid = l+r>>1;
                    if(arr[mid]>obstacles[i]){
                        r = mid;
                    }else{
                        l = mid+1;
                    }
                }
                arr[l] = obstacles[i];
                ans[i] = l+1;
            }

        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

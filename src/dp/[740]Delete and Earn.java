package dp;

import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class DeleteAndEarnSolution1 {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        //delete or not delete
        for(int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        int n = map.size();
        int[] arr = new int[n];
        int i = 0;
        for(int key:map.keySet()){
            arr[i++]=key;
        }
        Arrays.sort(arr);
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(n-1,arr);
    }


    public int dfs(int i, int[] arr){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int x = arr[i];
        //delete
        //find the first element that is smaller than arr[i] - 1;
        int j = i;
        while(j>0 && arr[j-1]>=x-1){
            j--;
        }
        int deleted = dfs(j-1,arr) + x * map.get(x);
        // not deleted
        int notDeleted = dfs(i-1,arr);
        return dp[i] = Math.max(deleted,notDeleted);
    }
}
class DeleteAndEarnSolution2 {
    HashMap<Integer,Integer> map = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        //delete or not delete
        for(int num:nums) map.put(num, map.getOrDefault(num, 0)+1);
        int n = map.size();
        int[] arr = new int[n];
        int k = 0;
        for(int key:map.keySet()){
            arr[k++]=key;
        }
        Arrays.sort(arr);
        int[] dp = new int[n+1];
        int j = 0;
        for(int i = 0;i<n;i++){
            int x = arr[i];
            //delete
            //find the first element that is smaller than arr[i] - 1;
            while(arr[j]<x-1){
                j++;
            }
            int deleted = dp[j] + x * map.get(x);
            // not deleted
            int notDeleted = dp[i];
            dp[i+1] = Math.max(deleted,notDeleted);
        }
        return dp[n];
    }

}
class DeleteAndEarnSolution3 {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        // Map<Integer,Integer> countMap =new HashMap<>();
        int[] countArr = new int[10001];
        for(int num:nums){
            max = Math.max(num,max);
            countArr[num]++;
        }
        int[] dp = new int[max+1];
        //dp[0]
        dp[1] = countArr[1]*1;
        for(int i = 2;i<=max;i++){
            dp[i] = Math.max(dp[i-2]+i*countArr[i], dp[i-1]);
        }
        return dp[max];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

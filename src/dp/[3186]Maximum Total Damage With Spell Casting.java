package dp;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumTotalDamageSolution1 {
    HashMap<Integer,Integer> powerMap = new HashMap<>();
    List<Integer> arr = new ArrayList<>();
    long[] dp;
    public long maximumTotalDamage(int[] power) {
        for(int p:power){
            powerMap.put(p, powerMap.getOrDefault(p, 0)+1);
        }
        arr.addAll(powerMap.keySet());
        Collections.sort(arr);
        dp = new long[arr.size()];
        Arrays.fill(dp,-1);
        return dfs(arr.size()-1);
    }

    public long dfs(int i){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int x = arr.get(i);
        //chosen
        long notChosen = dfs(i-1);
        //not chosen
        int j = i;
        while(j>0 && arr.get(j-1)>=x-2){
            j--;
        }
        long chosen = dfs(j-1)+ (long)powerMap.get(x) * x;
        return dp[i] = Math.max(chosen, notChosen);
    }
}
class MaximumTotalDamageSolution2 {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Integer> powerMap = new HashMap<>();
        for(int p:power){
            powerMap.put(p, powerMap.getOrDefault(p, 0)+1);
        }
        int n = powerMap.size();
        int k = 0;
        int[] arr = new int[n];
        for (int x : powerMap.keySet()) {
            arr[k++] = x;
        }
        Arrays.sort(arr);
        long[] dp = new long[n+1];
        int j = 0;
        for(int i = 0;i<n;i++){
            int x = arr[i];
            //chosen
            long notChosen = dp[i];
            //not chosen
            while(arr[j]<x-2){
                j++;
            }
            long chosen = dp[j]+ (long)powerMap.get(x) * x;
            dp[i+1] = Math.max(chosen, notChosen);
        }

        return dp[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

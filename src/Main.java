import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.maximumTotalDamage(new int[]{1,1,3,4});
    }

}
class Solution1 {
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
        while(j>0 && arr.get(j)>=x-2){
            j--;
        }
        long chosen = dfs(j-1)+ (long)powerMap.get(x) * x;
        return dp[i] = Math.max(chosen, notChosen);
    }
}
package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * Time Limit Exceeded
     * @param target
     * @param arr
     * @return
     */
    public int minOperationsTLE(int[] target, int[] arr){
        //朴素做法：求两个数组的最长公共子序列，然后用target-最长公共子序列长度
        int m = target.length;
        int n = arr.length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(target[i-1]==arr[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return m-dp[m][n];
    }

    /**
     * Convert LCS to LIS
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target, int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int m = target.length;
        int n = arr.length;
        for(int i = 0;i<m;i++){
            map.put(target[i],i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(arr[i])) list.add(map.get(arr[i]));
        }

        if(list.size()==0) return m;
        int[] temp = new int[list.size()];
        temp[0] = list.get(0);
        int end = 0;
        for(int i =1;i<list.size();i++){
            int cur = list.get(i);
            if(cur>temp[end]){
                end++;
                temp[end] = cur;
            }else{
                int l = 0, r = end;
                int toReplace = -1;
                while(l<r){
                    int mid = l+(r-l)/2;
                    if(temp[mid]==cur){
                        toReplace = mid;
                        break;
                    }else if(temp[mid]>cur){
                        r = mid;
                    }else{
                        l = mid+1;
                    }
                }
                if(toReplace==-1) toReplace = l;
                temp[toReplace] = cur;
            }
        }
        return m - (end+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

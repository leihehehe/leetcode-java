import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        for(int i = 0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],Math.min(map.get(words[i]),costs[i]));
            }else{
                map.put(words[i],costs[i]);
            }

        }
        int[][] memo = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            memo[i][n] = Integer.MAX_VALUE/2;
        }
        for(int i = 0;i<target.length();i++){
            for(int j = 0;j<target.length();j++){
                String word = target.substring(i,j+1);
                int minCost = Integer.MAX_VALUE/2;
                if(map.containsKey(word)){
                    int cost = map.get(word);
                    minCost = Math.min(memo[j+1][j+1]+cost,minCost);
                }
                memo[i][j] = Math.min(memo[i][j+1],minCost);
            }
        }

        return memo[0][0]==Integer.MAX_VALUE/2?-1:memo[0][0];
    }
}
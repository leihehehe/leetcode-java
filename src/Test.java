import java.util.*;

public class Test {
    public static void main(String[] args) {
        bitOperation.Solution solution = new bitOperation.Solution();
        solution.test();
    }
}
class Pair{
    char c;
    int count;
    public Pair(char c, int count){
        this.c= c;
        this.count = count;
    }
}
class Solution{
    void test(){
        HashMap<Character,Integer> freqMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b)->b.count-a.count);
        char[] chars = new char[]{'a','c','a','e','d','c','c'};
        for(char c: chars){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
            pq.add(new Pair(c,freqMap.get(c)));
        }
        char[] ans = new char[chars.length];
        int i = 0;
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && pq.peek().count!=freqMap.get(pq.peek().c)){
                pq.poll();
            }
            if(pq.isEmpty()){
                break;
            }
            ans[i++] = pq.poll().c;
        }
        System.out.println(ans);
    }
    HashMap<Character,Integer> map1 = new HashMap<>();
    HashMap<Character,Integer> map2 = new HashMap<>();
    public int findPermutationDifference(String s, String t) {
        for(int i = 0;i<s.length();i++){
            map1.put(s.charAt(i),i);
        }
        for(int i = 0;i<t.length();i++){
            map2.put(t.charAt(i),i);
        }
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            ans += Math.abs(map1.get(c)-map2.get(c));
        }
        return ans;
    }

    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dp = new int[m][n];

        for(int[] r:dp){
            Arrays.fill(r, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[1][0] = grid.get(1).get(0) - grid.get(0).get(0);
        dp[0][1] = grid.get(0).get(1) - grid.get(0).get(0);
        for(int i = 2;i<m;i++){
            for(int k = 0;k<i;k++){
                int cost = grid.get(i).get(0) - grid.get(k).get(0);
                dp[i][0] = Math.max(Math.max(dp[k][0] + cost ,cost),dp[i][0]);
            }
        }
        for(int i = 2;i<n;i++){
            for(int k = 0;k<i;k++){
                int cost = grid.get(0).get(i) - grid.get(0).get(k);
                dp[0][i] = Math.max(Math.max(dp[0][k] + cost,dp[0][i]),cost);
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                //from up
                for(int k = 0;k<i;k++){
                    int cost = grid.get(i).get(j) - grid.get(k).get(j);
                    dp[i][j] = Math.max(Math.max(dp[k][j] + cost ,dp[i][j]),cost);
                }
                //from left
                for(int k = 0;k<j;k++){
                    int cost = grid.get(i).get(j) - grid.get(i).get(k);
                    dp[i][j] = Math.max(Math.max(dp[i][k] + cost,dp[i][j]),cost);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        //last row
        for(int i = 0;i<n;i++){
            max = Math.max(max,dp[m-1][i]);
        }
        //last column
        for(int i = 0;i<m;i++){
            max = Math.max(max,dp[i][n-1]);
        }
        return max;
    }
}
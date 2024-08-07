package prefixSumAndDifference;

import java.util.*;

class CountPalindromePathsSolution1 {
    Map<Integer, Integer> map = new HashMap<>();
    private long res;

    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = s.length();
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());

        for (int i = 1; i < parent.size(); i++) {
            int father = parent.get(i);
            char c = s.charAt(i);
            graph[father].add(new int[]{i, 1 << (c - 'a')});
        }

        dfs(0, 0, graph);
        return res;
    }

    private void dfs(int x, int xor,List<int[]>[] graph) {
        res += map.getOrDefault(xor, 0);
        for (int i = 0; i < 26; ++i) {
            res += map.getOrDefault(xor ^ (1 << i), 0);
        }
        map.merge(xor, 1, Integer::sum);
        for (int[] neighbor : graph[x]) {
            int y = neighbor[0];
            int m = neighbor[1];
            dfs(y, xor ^ m,graph);
        }
    }
}
class CountPalindromePathsSolution2 {
    Map<Integer,Integer> map = new HashMap<>();
    public long countPalindromePaths(List<Integer> parent, String s) {
        //palindrome -> frequency -> even -> odd is 0
        //graph[i][j] = bit
        int n = s.length();
        //edcba
        List<int[]>[] graph= new ArrayList[n];
        Arrays.setAll(graph, e-> new ArrayList<>());
        for(int i = 1;i<parent.size();i++){
            int father = parent.get(i);
            char c = s.charAt(i);
            graph[father].add(new int[]{i,1<<(c-'a')});
        }
        map.put(0,1);
        return dfs(0,0,graph);
    }

    public long dfs(int mask, int i, List<int[]>[] graph){
        long ans = 0;
        for(int[] neighbor : graph[i]){
            int curMask = mask^neighbor[1];
            ans+=map.getOrDefault(curMask,0);
            for(int j = 0;j<26;j++){
                ans+=map.getOrDefault(curMask ^ (1<<j), 0);
            }
            map.merge(curMask,1,Integer::sum);
            ans+=dfs(curMask,neighbor[0],graph);
        }

        return ans;
    }
}

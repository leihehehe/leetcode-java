package dp;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPathSolution1 {
    List<Integer>[] graph;
    //最小值是1，因为至少有一个node
    int res = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int i = 1;i<n;i++) graph[parent[i]].add(i);
        dfs(0,s);
        return res;
    }
    //返回包含当前节点的最大深度
    public int dfs(int node, String s){
        int maxLen = 1;
        for(var neighbor: graph[node]){
            int curLen = dfs(neighbor,s);
            if(s.charAt(node)!=s.charAt(neighbor)){
                //先更新答案
                res = Math.max(res,maxLen+curLen);
                //再更新maxLen,这样防止加自己
                maxLen = Math.max(curLen+1,maxLen);
            }
        }
        return maxLen;
    }
}
class LongestPathSolution2 {
    Map<Integer,List<Integer>> map = new HashMap<>();
    int res = 0;
    public int longestPath(int[] parent, String s) {

        for(int i = 0;i<parent.length;i++){
            if(!map.containsKey(parent[i])){
                map.put(parent[i], new ArrayList<>());
            }
            List<Integer> list = map.get(parent[i]);
            list.add(i);
        }
        dfs(0,s);
        return res;
    }
    public int dfs(int node, String s){

        if(node == s.length()){
            return 0;
        }
        int longestPathThroughRoot = 1;
        List<Integer> children = map.get(node);
        int firstLarge = 0;
        int secondLarge = 0;
        if(children!=null){
            for(int child:children){
                //这个是我需要返回的值，而不是最终答案，所以无论他们相邻是不是有the same character都必须要得到这个值
                int cur= dfs(child,s);

                if(s.charAt(node)==s.charAt(child)){
                    continue;
                }
                longestPathThroughRoot = Math.max(cur+1,longestPathThroughRoot);
                if(cur>firstLarge){
                    secondLarge = firstLarge;
                    firstLarge = cur;
                }else if(cur>secondLarge){
                    secondLarge = cur;
                }

            }
        }

        res = Math.max(firstLarge + secondLarge + 1,res);
        return longestPathThroughRoot;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

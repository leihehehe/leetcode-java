package graph.topologicalSorting;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SortItemsSolution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] res = new int[n];
        List<Integer>[] itemGraph = new ArrayList[n];
        int[] itemIndegree = new int[n];
        int uniqueGroupId = m;
        for(int i = 0;i<n;i++){
            if(group[i]==-1)
                group[i] = uniqueGroupId++;
        }
        List<Integer>[] groupGraph = new ArrayList[uniqueGroupId+1];
        int[] groupIndegree = new int[uniqueGroupId];
        Arrays.setAll(itemGraph, e -> new ArrayList<>());
        Arrays.setAll(groupGraph, e -> new ArrayList<>());
        // HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            int curGroup = group[i];
            List<Integer> befores = beforeItems.get(i);
            for(int before:befores){
                itemGraph[before].add(i);
                int beforeGroup = group[before];
                //??
                if(beforeGroup!=curGroup && !groupGraph[beforeGroup].contains(curGroup)){
                    groupGraph[beforeGroup].add(curGroup);
                    groupIndegree[curGroup]++;
                }
            }
            itemIndegree[i]+=befores.size();
        }
        List<Integer> sortedGroups = sort(groupGraph,uniqueGroupId,groupIndegree);
        if(sortedGroups.size()!=uniqueGroupId) return new int[0];
        List<Integer> sortedItems = sort(itemGraph,n,itemIndegree);
        if(sortedItems.size()!=n) return new int[0];
        Map<Integer,ArrayList<Integer>> groupToItems = new HashMap<>();
        for(int gp:sortedGroups){
            groupToItems.putIfAbsent(gp, new ArrayList<>());
        }
        for(int item:sortedItems){
            int gp = group[item];
            groupToItems.get(gp).add(item);
        }
        int i  = 0;
        for(int gp:sortedGroups){
            for(int item:groupToItems.get(gp)){
                res[i++] = item;
            }
        }
        return res;
    }

    public List<Integer> sort(List<Integer>[] graph, int n, int[] indegree){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int item = queue.poll();
            res.add(item);
            for(int neighbor:graph[item]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0) queue.offer(neighbor);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

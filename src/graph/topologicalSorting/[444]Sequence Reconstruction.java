package graph.topologicalSorting;

import java.util.*;

class SequenceReconstructionSolution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        List<Integer>[] graph = new ArrayList[n+1];
        HashSet<Integer> set = new HashSet<>();
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] indegree = new int[n+1];
        for(List<Integer> sequence:sequences){
            int last = -1;
            for(int num:sequence){
                set.add(num);
                if(last!=-1 && !graph[last].contains(num)){
                    graph[last].add(num);
                    indegree[num]++;
                }
                last = num;
            }
        }
        if(set.size()!=nums.length) return false;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1;i<=n;i++){
            if(set.contains(i) && indegree[i]==0) queue.offer(i);
        }
        if(queue.size()>1) return false;
        int i = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num!=nums[i]) return false;
            int count = 0;
            for(int neighbor:graph[num]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                    count++;
                }
                if(count>1) return false;
            }
            i++;
        }
        return true;
    }
}
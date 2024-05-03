package graph.dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
        Map<Long,Integer> dis = new HashMap<>();
        long startNode = (long)start[0]<<32 | start[1];
        long targetNode = (long)target[0]<<32 | target[1];
        dis.put(startNode, 0);
        pq.offer(new long[]{startNode,0});
        while(!pq.isEmpty()){
            long[] nodeInfo = pq.poll();
            long node = nodeInfo[0];
            int cost = (int)nodeInfo[1];
            if(cost>dis.get(node)){
                continue;
            }

            //update neighbors
            //到终点
            int x = (int)(node>>32), y = (int)(node & Integer.MAX_VALUE);//???
            int targetCost = dis.get(node) + (Math.abs(target[0] - x) + Math.abs(target[1] - y));
            if(targetCost<dis.getOrDefault(targetNode,Integer.MAX_VALUE)){
                dis.put(targetNode,targetCost);
            }

            //到special road

            for(int[] road: specialRoads){
                //这里计算的是start->from->to，相当于是两条路径一起算了
                int newCost = dis.get(node) + Math.abs(road[0]-x) + Math.abs(road[1]-y) + road[4];
                long roadNode = (long) road[2]<<32|road[3];
                if(newCost < dis.getOrDefault(roadNode, Integer.MAX_VALUE)){
                    dis.put(roadNode,newCost);
                    pq.offer(new long[]{roadNode,newCost});
                }
            }
        }
        return dis.get(targetNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

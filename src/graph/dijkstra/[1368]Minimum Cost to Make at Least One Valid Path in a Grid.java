package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCostSolution {
    private final static int right = 1;
    private final static int left = 2;
    private final static int down = 3;
    private final static int up = 4;
    public int minCost(int[][] grid) {
        //箭头朝向的节点cost为0，其他为1。总共四个方向
        //dijkstra，每次选择min cost
        //{x,y,minCost}
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        int[] costs = new int[m*n];
        Arrays.fill(costs, Integer.MAX_VALUE/2);
        costs[0] = 0;
        pq.offer(new int[]{0,0,0});
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int x = node[0], y = node[1], minCost = node[2];
            int nodeId = x*n+y;
            if(minCost>costs[nodeId]){
                continue;
            }
            //update neighbors
            for(int[] dir:dirs){
                int newX = x+dir[0], newY = y+dir[1];
                int newId = newX*n+newY;
                if(newX<0 || newY<0 || newX>m-1 || newY>n-1) continue;
                //判断上下左右
                int cost = 0;
                if(newX>x && grid[x][y]==down || newX<x && grid[x][y]==up || newY>y && grid[x][y]==right || newY<y && grid[x][y]==left){
                    //no cost
                    cost = 0;
                }else{
                    cost = 1;
                }
                int newCost = costs[nodeId] + cost;
                if(newCost< costs[newId]){
                    costs[newId] = newCost;
                    pq.add(new int[]{newX,newY,newCost});
                }
            }
        }
        return costs[m*n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

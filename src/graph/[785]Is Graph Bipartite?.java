package graph;

import java.util.ArrayDeque;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Medium
 */
class IsBipartiteSolution1 {
    //既充当visited数组，又统计当前颜色
    private static final int UNCOLORED = -1;
    private static final int RED = 1;
    //blue -> 0
    private boolean isValid = true;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        //初始化
        for(int i = 0;i<n;i++){
            if(!isValid){
                break;
            }
            //这里保证循环的都是没有和上一个循环连通的节点
            if(color[i]==UNCOLORED)
                traverse(graph,i,RED);
        }

        return isValid;
    }

    public void traverse(int[][] graph, int i, int c){
        if(!isValid){
            return;
        }
        color[i] = c;
        int[] neighbors = graph[i];
        for(int neighbor: neighbors){
            //相同为0，不同为1
            if(color[neighbor] == c){
                isValid = false;
                break;
            }
            if(color[neighbor]==UNCOLORED){
                traverse(graph,neighbor,c^1);
            }
        }
    }
}
class IsBipartiteSolution2 {
    public boolean isBipartite(int[][] graph) {
        //bfs
        ArrayDeque<Integer> queue= new ArrayDeque<>();
        int n = graph.length;
        int[] color = new int[n];
        //-1 -> uncolored
        //0 -> red
        //1 -> blue
        Arrays.fill(color, -1);
        for(int i = 0;i<n;i++){
            queue.offer(i);
            //没被访问过
            if(color[i]==-1){
                //red
                color[i] = 0;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int j = 0;j<size;j++){
                        //检查neighbor
                        int cur = queue.poll();
                        int[] neighbors = graph[cur];
                        for(int neighbor:neighbors){
                            if(color[neighbor]==color[cur]){
                                return false;
                            }else if(color[neighbor]==-1){
                                //neighbor没被染色
                                color[neighbor] = color[cur] ^ 1;
                                queue.offer(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

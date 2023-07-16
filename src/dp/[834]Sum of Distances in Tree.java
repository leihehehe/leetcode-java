package dp;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Time Complexity - O(N)
 */
class SumOfDistancesInTree {
    private List<Integer>[] graph;
    private int[] answer;
    //每个节点为根节点时的子树大小
    private int[] count;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        //第一步构建图
        graph = new List[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        answer = new int[n];
        count = new int[n];
        dfs(0,-1,0);
        reRoot(0,-1,n);
        return answer;
    }

    /**
     * 这个方法就是计算0->各个节点的距离
     * @param cur
     * @param parent
     * @param depth
     */
    public void dfs(int cur, int parent, int depth){
        answer[0]+=depth;
        List<Integer> children = graph[cur];
        count[cur]=1;//节点数初始值算上当前他自己
        for (Integer child : children) {
            //我们要遍历cur的孩子节点，但cur存储的children列表中是有parent的，所以需要跳过
            if(child!=parent){
                dfs(child,cur,depth+1);
                //后序遍历，当前子树的节点个数=所有子节点的count相加+1(节点自己，在前面初始化了)
                count[cur]+= count[child];
            }
        }
    }

    public void reRoot(int cur, int parent, int n){
        List<Integer> children = graph[cur];
        for(Integer child:children){
            if(child!=parent){
                answer[child] = answer[cur] - count[child] + (n - count[child]);
                reRoot(child,cur,n);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

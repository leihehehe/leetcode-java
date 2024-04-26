package backtracking;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumMoves {
    class Node{
        private int x;
        private int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int minimumMoves(int[][] grid) {
        List<Node> from = new ArrayList<>();
        List<Node> to = new ArrayList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]>1){
                    for(int c = 0;c<grid[i][j]-1;c++){
                        from.add(new Node(i,j));
                    }
                }
                if(grid[i][j]==0){
                    to.add(new Node(i,j));
                }
            }
        }

        visited = new boolean[from.size()];
        dfs(0,from,to);
        return res;
    }
    boolean[] visited;
    List<Node> path = new ArrayList<>();
    int res = Integer.MAX_VALUE;
    public void dfs(int i,List<Node> from,List<Node> to){
        if(i==from.size()){
            int curRes= 0;
            for(int j = 0;j<path.size();j++){
                curRes+=Math.abs(path.get(j).x-to.get(j).x) + Math.abs(path.get(j).y-to.get(j).y);
            }
            res = Math.min(res,curRes);
            return;
        }

        for(int x = 0;x<from.size();x++){
            Node node = from.get(x);
            if(!visited[x]){
                path.add(node);
                visited[x] = true;
                dfs(i+1,from,to);
                path.remove(path.size()-1);
                visited[x] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

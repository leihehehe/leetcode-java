package unionFind;

/**
 * Leetcode 130
 */
class SurroundedRegions {
    public void solve(char[][] board) {
        if(board==null && board.length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        int dummy = rows*cols;
        UnionFind unionFind = new UnionFind(dummy);
        int[][] d = {{1,0},{0,1},{0,-1},{-1,0}};
        for(int i = 0;i<rows;i++){
            for(int j = 0; j<cols;j++){
                if(board[i][j]=='O'){
                    if(i==0||i==rows-1||j==0||j==cols-1){
                        //on the border
                        unionFind.union(i*cols+j,dummy);
                    }else{
                        //not on the border
                        for (int k = 0;k<4;k++){
                            int x =i+d[k][0];
                            int y =j+d[k][1];
                            //union the Os
                            if(board[x][y]=='O') unionFind.union(x*cols+y,i*cols+j);
                        }
                    }
                }

            }
        }
        for(int i =1;i<rows-1;i++){
            for(int j =1;j<cols-1;j++){
                if(board[i][j]=='O' &&!unionFind.connected(dummy,i*cols+j)){
                    board[i][j]='X';
                }
            }
        }
    }
    class UnionFind{
        private int[] parents;
        public UnionFind(int dummy){
            //store all the letters and also dummy node
            parents = new int[dummy+1];
            for(int i=0;i<=dummy;i++){
                parents[i]=i;
            }
        }
        public int find(int node){
            while(node!=parents[node]){
                node = parents[node];
            }
            return node;
        }
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1!=root2) parents[root1]=root2;
        }
        public boolean connected(int node1, int node2){
            return find(node1)==find(node2);
        }
    }
}

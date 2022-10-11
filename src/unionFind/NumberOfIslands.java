package unionFind;

public class NumberOfIslands {
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        cols = grid[0].length;
        rows = grid.length;
        UnionFind unionFind = new UnionFind(cols*rows);
        int[][] directions = {{1,0},{0,1}};
        int spaces = 0;
        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(grid[i][j]=='1'){
                    for(int[] direction: directions){
                        int newRow = i+ direction[0];
                        int newCol=j+direction[1];
                        if(newRow<rows&&newCol<cols&&grid[newRow][newCol]=='1'){
                            unionFind.union(getIndex(i,j),getIndex(newRow,newCol));
                        }
                    }
                }else{
                    spaces++;
                }
            }
        }
        return unionFind.getCount()-spaces;


    }
    public int getIndex(int i, int j){
        return i*cols+j;
    }
    private class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            for(int i =0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int node){
            if(parent[node]!=node){
                parent[node]= find(parent[node]);
            }
            return parent[node];
        }
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1==root2) return;
            parent[root1]=root2;
            count--;
        }
        public int getCount(){
            return this.count;
        }
    }
}

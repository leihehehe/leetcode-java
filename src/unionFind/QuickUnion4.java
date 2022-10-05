package unionFind;

/***
 * Leetcode 547
 */
public class QuickUnion4 {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind unionFind = new QuickUnion4.UnionFind(len);
        for(int i =0;i<len;i++){
            for(int j=0;j<i;j++){
                if(isConnected[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }
    class UnionFind{
        private int[] parent;
        //to optimize the complexity, we are connecting a smaller size tree to another tree.
        private int[] rank;
        private int count;
        private int N;
        public int getCount(){
            return count;
        }
        public UnionFind(int N){
            this.N= N;
            this.count = N;
            this.rank = new int[N];
            this.parent = new int[N];
            for(int i =0;i<N;i++){
                parent[i] = i;
                rank[i]=1;
            }
        }
        public int find(int x){
            //if x equals parent[x], its a root node
            while (x != parent[x]) {
                //find the parent's parent node
                x = parent[parent[x]];
            }
            return x;
        }

        /***
         * Another find method -> using recursion
         * @param x
         * @return
         */
        public int findMethod2(int x){
            if(parent[x]!=x){
                //connect all nodes to the root node.
                parent[x]=findMethod2(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            //get the root of x and the root of y
            int xRoot= find(x);
            int yRoot= find(y);
            if(xRoot==yRoot){
                return;
            }
            if(rank[xRoot]==rank[yRoot]){
                parent[xRoot]=yRoot;
                rank[xRoot]+=1;
            }else if(rank[xRoot]<rank[yRoot]){
                parent[xRoot]=yRoot;
            }else{
                parent[xRoot]=yRoot;
            }

            count--;
        }
    }
}

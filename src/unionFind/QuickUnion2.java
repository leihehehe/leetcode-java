package unionFind;

/***
 * Leetcode 547
 * Time complexity: N^2LogN
 * - find: O(logN)
 * - union: O(logN)
 * Space complexity: O(N)
 */
public class QuickUnion2 {
    public int findProvinceNum(int[][] M){
        int len = M.length;
        UnionFind unionFind = new UnionFind(len);
        for(int i =0;i<len;i++){
            for(int j=0;j<i;j++){
                if(M[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }
    class UnionFind{
        //value->id
        private int[] parent;
        //to optimize the complexity, we are connecting a smaller size tree to another tree.
        private int[] size;
        private int count;
        private int N;
        public int getCount(){
            return count;
        }
        public UnionFind(int N){
            this.N= N;
            this.count = N;
            this.parent = new int[N];
            this.size = new int[N];
            for(int i =0;i<N;i++){
                parent[i] = i;
                size[i]=1;
            }
        }
        public int find(int x){
            //if x equals parent[x], its a root node
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y){
            //get the root of x and the root of y
            int xRoot= find(x);
            int yRoot= find(y);
            if(xRoot==yRoot){
                return;
            }
            if(size[xRoot]==size[yRoot]){
                parent[xRoot]=yRoot;
                size[yRoot]+=size[xRoot];
            }else if(size[xRoot]<size[yRoot]){
                parent[xRoot]=yRoot;
                size[yRoot]+=size[xRoot];
            }else{
                parent[yRoot]=xRoot;
                size[xRoot]+=size[yRoot];
            }
            count--;
        }
    }
}

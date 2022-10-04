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
            //find out the root
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }
        public void union(int x, int y){
            //change all xId to yId, so that they could be the same Ids
            int xId= find(x);
            int yId= find(y);
            if(xId==yId){
                return;
            }
            if(size[xId]==size[yId]){
                parent[xId]=yId;
                size[yId]+=size[xId];
            }else if(size[xId]<size[yId]){
                parent[xId]=yId;
                size[yId]+=size[xId];
            }else{
                parent[yId]=xId;
                size[xId]+=size[yId];
            }
            count--;
        }
    }
}

package unionFind;

/***
 * Leetcode 547
 * Time complexity: O(N^2logN)
 * Space complexity: O(N)
 */
public class QuickUnion1 {
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
        //Use an array to represent a tree.
        private int[] parent;
        private int count;
        private int N;
        public int getCount(){
            return count;
        }
        public UnionFind(int N){
            this.N= N;
            this.count = N;
            this.parent = new int[N];
            for(int i =0;i<N;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
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
            parent[xId]=yId;
            count--;
        }
    }
}

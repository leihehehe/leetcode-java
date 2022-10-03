package unionFind;

public class QuickFind {
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
        private int[] id;
        private int count;
        private int N;
        public int getCount(){
            return count;
        }
        public UnionFind(int N){
            this.N= N;
            this.count = N;
            this.id = new int[N];
            for(int i =0;i<N;i++){
                id[i] = i;
            }
        }
        public int find(int x){
            return id[x];
        }
        public void union(int x, int y){
            //change all xId to yId, so that they could be the same Ids
            int xId= find(x);
            int yId= find(y);
            if(xId==yId){
                return;
            }
            for (int i =0;i<N;i++){
                if(id[i]==xId){
                    id[i]=yId;
                }
            }
            count--;
        }


    }
}

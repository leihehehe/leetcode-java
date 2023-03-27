package unionFind;

public class UF {
    private int count;
    private int[] parent;
    private int[] size;
    public UF(int n){
        this.count = n;
        parent=new int[n];
        for(int i =0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    /**
     * Time complexity: O(logN)
     * @param q
     * @param p
     */
    public void union(int q, int p){
        int rootQ = find(q);
        int rootP = find(p);
        if(rootQ==rootP) return;
        if(size[rootP]>size[rootQ]){
            parent[rootQ]=rootP;
            size[rootP]+=size[rootQ];
        }else{
            parent[rootP]=rootQ;
            size[rootQ]+=size[rootP];
        }
        count--;
    }

    /**
     * Time complexity: O(logN)
     * @param x
     * @return
     */
    public int find(int x){
        //root of x == x itself
        while(parent[x]!=x)
            parent[x]=parent[parent[x]];
            x = parent[x];
        return x;
    }
    public int count(){
        return count;
    }
    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }
}

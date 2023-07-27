package graph;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * UnionFind
 */
class ValidateBinaryTreeNodesSolution1 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //indegree == 0 -> root
        //we can walk from root to every node
        int[] inDegree = new int[n];
        for(int i = 0;i<n;i++){
            int left = leftChild[i];
            int right = rightChild[i];
            if(left!=-1){
                inDegree[left]++;
            }
            if(right!=-1){
                inDegree[right]++;
            }
        }
        int count = 0;
        for(int i =0;i<n;i++){
            int in = inDegree[i];
            if(in==0){
                count++;
            }
            if(count>1){
                return false;
            }
        }

        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<n;i++){
            int left = leftChild[i];
            int right = rightChild[i];
            if(left!=-1){
                if(!uf.union(i,left)){
                    return false;
                }
            }
            if(right!=-1){
                if(!uf.union(i,right)){
                    return false;
                }
            }
        }
        return uf.getCount()==1;

    }

    class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i = 0;i<parent.length;i++){
                parent[i] = i;
            }
        }

        public boolean union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP==rootQ){
                return false;
            }
            parent[rootP] = rootQ;
            count--;
            return true;
        }
        public int find(int node){
            if(parent[node]!=node){
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
        public boolean connected(int p, int q){
            return find(p)==find(q);
        }
        public int getCount(){
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ValidateBinaryTreeNodesSolution2 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //indegree == 0 -> root
        //we can walk from root to every node
        int[] inDegree = new int[n];
        for(int i = 0;i<n;i++){
            int left = leftChild[i];
            int right = rightChild[i];
            if(left!=-1){
                inDegree[left]++;
            }
            if(right!=-1){
                inDegree[right]++;
            }

        }
        int root = -1;
        int count = 0;
        for(int i =0;i<n;i++){
            int in = inDegree[i];
            if(in==0){
                root = i;
                count++;
            }
            if(count>1){
                return false;
            }
        }
        //found root
        boolean[] visited =new boolean[n];


        return dfs(root,leftChild,rightChild,visited) && checkVisited(visited);
    }
    public boolean dfs(int root, int[] leftChild, int[] rightChild, boolean[] visited){
        if(root==-1){
            return true;
        }
        //check cycle
        if(visited[root]){
            return false;
        }
        visited[root] = true;
        //traverse the tree
        return dfs(leftChild[root],leftChild,rightChild,visited) && dfs(rightChild[root],leftChild,rightChild,visited);
    }
    public boolean checkVisited(boolean[] visited){
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
}